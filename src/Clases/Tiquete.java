/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Enums.TipoTramite;
import Enums.Tramite;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author adrianhidalgo
 */
public class Tiquete {

    private String caja;
    private String nombre;
    private int edad;
    private String id;
    private String horaCreacion;
    private int horaAtencion; // -1 por defecto
    private int Deposito;
    private int Retiro;
    private int Cambio;
    private TipoTramite tipo;

    // Constructor

    public Tiquete(String nombre, int edad, String id, String horaCreacion, int horaAtencion) {
        this.nombre = nombre;
        this.edad = edad;
        this.id = id;
        this.horaCreacion = horaCreacion;
        this.horaAtencion = horaAtencion;
    }

    public String getCaja() {
        return caja;
    }

    public void setCaja(String caja) {
        this.caja = caja;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre() {
        boolean valido = false;
        while (!valido) {
            nombre = javax.swing.JOptionPane.showInputDialog("Ingrese el nombre:");
            if (nombre != null && !nombre.trim().equals("")) {
                this.nombre = nombre;
                valido = true;
            } else {
                javax.swing.JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío.");
            }
        }
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad() {
        boolean valido = false;
        while (!valido) {
            try {
                String entrada = javax.swing.JOptionPane.showInputDialog("Ingrese la edad (1 - 99):");
                edad = Integer.parseInt(entrada);
                if (edad >= 1 && edad <= 99) {
                    this.edad = edad;
                    valido = true;
                } else {
                    javax.swing.JOptionPane.showMessageDialog(null, "La edad debe estar entre 1 y 99.");
                }
            } catch (NumberFormatException e) {
                javax.swing.JOptionPane.showMessageDialog(null, "Debe ingresar un número válido.");
            }
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHoraCreacion() {
        return horaCreacion;
    }

    public void setHoraCreacion() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");
        this.horaCreacion = LocalTime.now().format(formato);
    }

    public int getHoraAtencion() {
        return horaAtencion;
    }

    public void setHoraAtencion(int horaAtencion) {
        this.horaAtencion = horaAtencion;
    }

    public int getDeposito() {
        return Deposito;
    }

    public void setDeposito(int Deposito) {
        this.Deposito = Deposito;
    }

    public int getRetiro() {
        return Retiro;
    }

    public void setRetiro(int Retiro) {
        this.Retiro = Retiro;
    }

    public int getCambio() {
        return Cambio;
    }

    public void setCambio(int Cambio) {
        this.Cambio = Cambio;
    }

    
    
    

//    public void setTramite() {
//        boolean valido = false;
//        while (!valido) {
//            String opcion = javax.swing.JOptionPane.showInputDialog("Seleccione el trámite:\n1. depositos\n2. retiros\n3. cambio de divisas");
//
//            if (opcion != null) {
//                switch (opcion) {
//                    case "1":
//                        this.tramite = Tramite.depositos;
//                        valido = true;
//                        break;
//                    case "2":
//                        this.tramite = Tramite.retiros;
//                        valido = true;
//                        break;
//                    case "3":
//                        this.tramite = Tramite.cambio_Divisas;
//                        valido = true;
//                        break;
//                    default:
//                        javax.swing.JOptionPane.showMessageDialog(null, "Opción no válida. Intente de nuevo.");
//                        break;
//                }
//            } else {
//                javax.swing.JOptionPane.showMessageDialog(null, "Debe seleccionar una opción.");
//            }
//        }
//    }

    public TipoTramite getTipo() {
        return tipo;
    }

    public void setTipo(TipoTramite tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Tiquete{" + "caja=" + caja + ", nombre=" + nombre + ", edad=" + edad + ", id=" + id + ", horaCreacion=" + horaCreacion + ", horaAtencion=" + horaAtencion + ", Deposito=" + Deposito + ", Retiro=" + Retiro + ", Cambio=" + Cambio + ", tipo=" + tipo + '}';
    }

    
}
