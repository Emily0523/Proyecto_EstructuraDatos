/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Enums.TipoTramite;
import javax.swing.JOptionPane;

public class ManejoBanco {

    private ColaPrioridad cajas; // una Cola por cada caja

    // 1) El usuario decide cuántas cajas habrá
    public void configurarCajas() throws Exception {
        boolean ok = false;
        while (!ok) {
            try {
                String s = javax.swing.JOptionPane.showInputDialog("¿Cuántas cajas tendrá el banco?");
                if (s == null) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Sistema cerrado");
                    System.exit(0);
                }
                int n = Integer.parseInt(s);

                if (n >= 3) {
                    cajas = new ColaPrioridad();
                    for (int i = 0; i < n; i++) {
                        switch (i) {
                            case 0 ->
                                cajas.encolar(new Cola(TipoTramite.P), i + 1);
                            case 1 ->
                                cajas.encolar(new Cola(TipoTramite.A), i + 1);
                            default ->
                                cajas.encolar(new Cola(TipoTramite.B), i + 1);
                        }
                    }
                    javax.swing.JOptionPane.showMessageDialog(null, "Se crearon " + n + " cajas.");
                    ok = true;
                } else {
                    throw new Exception("Debe ser un número mayor o igual a 3.");
                }
            } catch (NumberFormatException e) {
                javax.swing.JOptionPane.showMessageDialog(null, "Ingrese un número válido.");
            } catch (Exception e) {
                javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }

    private boolean cajasListas() {
        if (cajas == null || cajas.getTamano() == 0) {
            javax.swing.JOptionPane.showMessageDialog(null, "Primero configure la cantidad de cajas.");
            return false;
        }
        return true;
    }

    //Encolar un tiquete
    public void encolarEnCaja() {
        if (!cajasListas()) {
            return;
        }

        try {
            int opcion;

            String name = javax.swing.JOptionPane.showInputDialog("Ingrese su nombre:");
            if (name == null) {
                javax.swing.JOptionPane.showMessageDialog(null, "Sistema cerrado");
                System.exit(0);
            }

            String ID = javax.swing.JOptionPane.showInputDialog("Ingrese su Identificacion:");
            if (ID == null) {
                javax.swing.JOptionPane.showMessageDialog(null, "Sistema cerrado");
                System.exit(0);
            }

            String yo = javax.swing.JOptionPane.showInputDialog("Ingrese su edad:");
            if (yo == null) {
                javax.swing.JOptionPane.showMessageDialog(null, "Sistema cerrado");
                System.exit(0);
            }

            Tiquete ticket = new Tiquete(name, Integer.parseInt(yo), ID, "00:00", "-1");

            do {
                String tramite = javax.swing.JOptionPane.showInputDialog(
                        "Seleccione el tramite a realizar \n1. Depósito\n2. Retiro\n3. Cambio de divisas"
                );
                if (tramite == null) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Sistema cerrado");
                    System.exit(0);
                }

                int n = Integer.parseInt(tramite);
                String nombreTramite = "";

                switch (n) {
                    case 1 ->
                        nombreTramite = "depósitos";
                    case 2 ->
                        nombreTramite = "retiros";
                    case 3 ->
                        nombreTramite = "cambios de divisas";
                    default -> {
                        javax.swing.JOptionPane.showMessageDialog(null, "Opción inválida.");
                        return;
                    }
                }

                String cant = javax.swing.JOptionPane.showInputDialog("¿Cuántos " + nombreTramite + " desea realizar?");
                if (cant == null) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Sistema cerrado");
                    System.exit(0);
                }

                int c = Integer.parseInt(cant);

                switch (n) {
                    case 1 ->
                        ticket.setDeposito(c);
                    case 2 ->
                        ticket.setRetiro(c);
                    case 3 ->
                        ticket.setCambio(c);
                }

                opcion = JOptionPane.showConfirmDialog(
                        null,
                        "¿Deseas realizar otro tipo de trámite?",
                        "Trámites",
                        JOptionPane.YES_NO_OPTION
                );

            } while (opcion == JOptionPane.YES_OPTION);

            int Discapacidad = JOptionPane.showConfirmDialog(
                    null,
                    "¿Presenta usted algun tipo de discapacidad?",
                    "Tramites",
                    JOptionPane.YES_NO_OPTION);
            if (Discapacidad == JOptionPane.YES_OPTION) {
                ticket.setTipo(TipoTramite.P);
            } else if ((ticket.getDeposito() + ticket.getCambio() + ticket.getRetiro()) == 1) {
                ticket.setTipo(TipoTramite.A);
            } else {
                ticket.setTipo(TipoTramite.B);
            }

            nodo laCaja = cajas.Prioridad(ticket.getTipo());

            ticket.setCaja(laCaja.getNumCaja() + "");
            laCaja.getColaT().encolar(ticket);

            javax.swing.JOptionPane.showMessageDialog(null, laCaja.getColaT().Posicion(ticket));

        } catch (NumberFormatException e) {

        }
    }

    // 3) Atender en una caja específica
    public void atenderCaja() throws Exception {
        if (!cajasListas()) {
            return;
        }

        try {
            String s = javax.swing.JOptionPane.showInputDialog("¿De cuál caja desea atender? (1 - " + cajas.getTamano() + ")");
            if (s == null) {
                javax.swing.JOptionPane.showMessageDialog(null, "Sistema cerrado");
                System.exit(0);
            }
            int numCaja = Integer.parseInt(s);
            nodo aux = cajas.getPrim();

            if (numCaja > cajas.getTamano()) {
                throw new Exception("Numero de caja invalido.");
            }

            while (aux != null) {
                if (aux.getNumCaja() == numCaja) {
                    aux.getColaT().TiqueteAtendido();

                    if (aux.getColaT().getPrim() != null) {
                        aux.getColaT().getPrim().getTicket().setHoraAtencion();
                        javax.swing.JOptionPane.showMessageDialog(null, "Siguiente tickete a ser atendido: " + aux.getColaT().getPrim().toString());
                    } else {
                        javax.swing.JOptionPane.showMessageDialog(null, "La caja quedó vacía.");
                    }
                }

                aux = aux.getSig();
            }

        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(null, "Número de caja inválido.");
        }
    }

    // 3) Mostrar el estado de todas las colas
    public void mostrarTodasLasCajas() {
        if (!cajasListas()) {
            return;
        }

        javax.swing.JOptionPane.showMessageDialog(null, cajas.toString());
    }
}
