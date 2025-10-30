/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author adrianhidalgo
 */
public class nodo {

    // Atributos
    private Cola colaT;   // Puede guardar cualquier tipo de dato (por ejemplo un tiquete)
    private nodo sig;      // Referencia al siguiente nodo
    private int NumCaja;

    // Constructor vacío
    public nodo() {
        this.colaT = null;
        this.sig = null;
        NumCaja = 0;
    }

    // Constructor con dato
    public nodo(Cola colaT, int NumCaja) {
        this.colaT = colaT;
        this.sig = null;
        this.NumCaja = NumCaja;
        
    }

    // Getters y Setters
   
    public Cola getColaT() {
        return colaT;
    }

    public void setColaT(Cola colaT) {
        this.colaT = colaT;
    }
    
    public nodo getSig() {
        return sig;
    }

    public void setSig(nodo sig) {
        this.sig = sig;
    }

    public int getNumCaja() {
        return NumCaja;
    }

    // toString
    @Override
    public String toString() {
        return colaT.toString();
    }
}
