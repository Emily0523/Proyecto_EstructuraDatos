/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

public class nodoTiquetes {

    // Atributos
    private Tiquete Ticket;
    private nodoTiquetes sig;      // Referencia al siguiente nodo

    // Constructor vacío
    public nodoTiquetes() {
        this.Ticket = null;
        this.sig = null;
    }

    // Constructor con dato
    public nodoTiquetes(Tiquete Ticket) {
        this.Ticket = Ticket;
        this.sig = null;
    }

    // Getters y Setters
    public Tiquete getTicket() {
        return Ticket;
    }

    public void setTicket(Tiquete Ticket) {
        this.Ticket = Ticket;
    }

    public nodoTiquetes getSig() {
        return sig;
    }

    public void setSig(nodoTiquetes sig) {
        this.sig = sig;
    }

    // toString
    @Override
    public String toString() {
        return Ticket.toString();
    }
}
