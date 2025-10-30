/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Enums.TipoTramite;

/**
 *
 * @author roger
 */
public class ColaPrioridad {
    private nodo prim;
    private nodo ult;
    private int tamano;

    // Constructor
    public ColaPrioridad() {
        prim = null;
        ult = null;
        tamano = 0;
    }

    // Método para encolar una Cola
    public void encolar(Cola c, int n) {
        nodo nuevo = new nodo(c, n);
        if (prim == null) { // Si la cola está vacía
            prim = nuevo;
            ult = nuevo;
        } else {
            ult.setSig(nuevo);
            ult = nuevo;
        }
        tamano++;
    }

    // Método para obtener prioridad de caja
    public nodo Prioridad(TipoTramite Tipocola) {
        if (prim == null) return null;

        nodo actual = prim;
        
        while (actual != null) {
            if (actual.getColaT().getTipocola() == Tipocola){
                break;                
            }
            actual = actual.getSig();
        }
        
        
        
        nodo mayorP = actual;

        while (actual != null) {
            if (actual.getColaT().getTamano() < mayorP.getColaT().getTamano() && actual.getColaT().getTipocola() == mayorP.getColaT().getTipocola()){
                mayorP = actual;                
            }
            actual = actual.getSig();
        }
        
       return mayorP;
    }

    // Mostrar todos los Tiquetes en la cola
    @Override
    public String toString() {
        if (prim == null) {
            return "La cola está vacía.";
        } else {
            String texto = "";
            nodo aux = prim;
            while (aux != null) {
                texto += aux.getColaT().toString() + "\n";
                aux = aux.getSig();
            }
            return texto;
        }
    }

    // Getter de tamaño
    public int getTamano() {
        return tamano;
    }

    public nodo getPrim() {
        return prim;
    }
    
}
