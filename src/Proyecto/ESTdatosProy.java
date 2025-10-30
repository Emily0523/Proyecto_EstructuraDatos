/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package Proyecto;

import Clases.Cola;
import Clases.ManejoBanco;
import Enums.TipoTramite;
import javax.swing.JOptionPane;

public class ESTdatosProy {

    public static void main(String[] args) throws Exception {

        ManejoBanco BAC = new ManejoBanco();
        String nameBanco = javax.swing.JOptionPane.showInputDialog("Ingrese el nombre del banco: ");
        if (nameBanco == null) {
            javax.swing.JOptionPane.showMessageDialog(null, "Sistema cerrado");
            System.exit(0);
        }
        javax.swing.JOptionPane.showMessageDialog(null, "Bienvenido(a) al sistema del banco:  " + nameBanco + "");

        String MainOption = "";

        do {
            try {
                MainOption = javax.swing.JOptionPane.showInputDialog("Menu: \n1. Crear cajas\n2. Crear tiquete\n3. Verificar Cajas\n4. Atender tiquete \n5. Salir.");
                if (MainOption == null) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Sistema cerrado");
                    System.exit(0);
                }
                switch (Integer.parseInt(MainOption)) {
                    case 1 ->
                        BAC.configurarCajas();
                    case 2 ->
                        BAC.encolarEnCaja();
                    case 3 ->
                        BAC.mostrarTodasLasCajas();
                    case 4 ->
                        BAC.atenderCaja();
                    case 5 ->
                        MainOption = "5";
                    default ->
                        javax.swing.JOptionPane.showMessageDialog(null, "Opcion inválida.");
                }

            } catch (Exception ex) {
                javax.swing.JOptionPane.showMessageDialog(null, "Opcion inválida.");
                MainOption = "0";
            }

        } while (Integer.parseInt(MainOption) != 5);

    }
}
