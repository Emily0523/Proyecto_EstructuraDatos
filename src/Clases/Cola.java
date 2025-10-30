/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Enums.*;

/**
 *
 * @author adrianhidalgo
 */
public class Cola {

    // Atributos
    private nodoTiquetes prim;
    private nodoTiquetes ult;
    private int tamano;
    private TipoTramite Tipocola;

    // Constructor

    public Cola(TipoTramite Tipocola) {
        prim = null;
        ult = null;
        tamano = 0;
        this.Tipocola = Tipocola;
    }
    
    
    
    // Método para encolar un Tiquete
    public void encolar(Tiquete t) {
        nodoTiquetes nuevo = new nodoTiquetes(t);
        if (prim == null) { // Si la cola está vacía
            prim = nuevo;
            ult = nuevo;
        } else {
            ult.setSig(nuevo);
            ult = nuevo;
        }
        tamano++;
        javax.swing.JOptionPane.showMessageDialog(null, "Tiquete encolado correctamente.");
    }

    // Método para atender (sacar el primero)
    public Tiquete atender() {
        if (prim == null) {
            javax.swing.JOptionPane.showMessageDialog(null, "La cola está vacía.");
            return null;
        } else {
            Tiquete t = (Tiquete) prim.getTicket();
            prim = prim.getSig();
            if (prim == null) {
                ult = null; // Si la cola quedó vacía
            }
            tamano--;
            javax.swing.JOptionPane.showMessageDialog(null, "Se atendió el tiquete de: " + t.getNombre());
            return t;
        }
    }

    // Mostrar todos los Tiquetes en la cola
    @Override
    public String toString() {
        if (prim == null) {
            return "La cola está vacía.";
        } else {
            String texto = "";
            nodoTiquetes aux = prim;
            while (aux != null) {
                texto += aux.getTicket().toString() + "\n";
                aux = aux.getSig();
            }
            return texto;
        }
    }

    
    
    public String Posicion(Tiquete t) {
        
        int cantClient=0;
        if (prim.getTicket() == t) {
            return "Es su turno de atencion";
        } else {
            String texto = "Su turno es despues de: ";
            nodoTiquetes aux = prim;
            while (aux.getTicket() != t) {
                cantClient ++;
                aux = aux.getSig();
            }
            return texto + cantClient + " personas";
        }
    }
    
    public void TiqueteAtendido(){
        
        if(prim == null){
            
        } else {
            
            if(prim == ult) {
                prim = ult = null;
            } else{
                prim = prim.getSig();
            }
            tamano--;
        }
        
    }
    
    // Getter de tamaño
    public int getTamano() {
        return tamano;
    }

    public TipoTramite getTipocola() {
        return Tipocola;
    }

    public nodoTiquetes getPrim() {
        return prim;
    }
    
}
