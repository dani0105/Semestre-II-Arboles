/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Tree;

import Grafo.Vertex;
import HashTable.User;

/**
 *
 * @author DanielR
 */
public class Node {

    private int id;
    private double itemWeight;
    private Node izq;
    private Node der;
    private User user;
    private Vertex sender;
    private Vertex receiver;

    public Node(int id, double itemWeight, User user, Vertex sender, Vertex receiver) {
        this.id = id;
        this.itemWeight = itemWeight;
        this.user = user;
        this.sender = sender;
        this.receiver = receiver;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getItemWeight() {
        return itemWeight;
    }

    public void setItemWeight(double itemWeight) {
        this.itemWeight = itemWeight;
    }

    public Node getIzq() {
        return izq;
    }

    public void setIzq(Node izq) {
        this.izq = izq;
    }

    public Node getDer() {
        return der;
    }

    public void setDer(Node der) {
        this.der = der;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

   

    public Vertex getSender() {
        return sender;
    }

    public void setSender(Vertex sender) {
        this.sender = sender;
    }

    public Vertex getReceiver() {
        return receiver;
    }

    public void setReceiver(Vertex receiver) {
        this.receiver = receiver;
    }
}