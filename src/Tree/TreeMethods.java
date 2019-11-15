/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

import Grafo.Vertex;
import HashTable.*;
import static Enums.Licenses.*;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;

/**
 *
 * @author DanielR
 */
public class TreeMethods {

    public Node root;
    private int addVar;
    private int modVar;

    public TreeMethods() {
      
    }

    /*
    add order
    @ return  1 = the order already exists
    @ return  2 = the user is not suitable for this type of merchandise
    @ return  3 = the order was added
     */
    public int add(int id, double itemWeight, Vertex sender, Vertex receiver, Node aux, User user) {
        
        if (root == null) {
            Node node = new Node(id, itemWeight, user, sender, receiver);
            root = node;
            return addVar = 3;
        } else {
            Node node = new Node(id, itemWeight, user, sender, receiver);
            if (id == aux.getId()) {
                return addVar = 1;
            } else {
                if (id < aux.getId()) {
                    if (aux.getIzq() == null) {
                        if (itemWeight < 4) {
                            if (user.getLicense().equals(B1)) {
                                aux.setIzq(node);
                                return addVar = 3;
                            }
                        } else if (itemWeight < 8) {
                            if (user.getLicense().equals(B2)) {
                                aux.setIzq(node);
                                return addVar = 3;
                            }
                        } else {
                            if (user.getLicense().equals(B3) || user.getLicense().equals(B4)) {
                                aux.setIzq(node);
                                return addVar = 3;
                            }
                        }
                        return addVar = 2;
                    } else {
                        add(id, itemWeight, sender, receiver, aux.getIzq(), user);
                    }
                } else {
                    if (aux.getDer() == null) {
                        if (itemWeight < 4) {
                            if (user.getLicense().equals(B1)) {
                                aux.setDer(node);
                                return addVar = 3;
                            }
                        } else if (itemWeight < 8) {
                            if (user.getLicense().equals(B2)) {
                                aux.setDer(node);
                                return addVar = 3;
                            }
                        } else {
                            if (user.getLicense().equals(B3) || user.getLicense().equals(B4)) {
                                aux.setDer(node);
                                return addVar = 3;
                            }
                        }
                        return addVar = 2;
                    } else {
                        add(id, itemWeight, sender, receiver, aux.getDer(), user);
                    }
                }
            }
        }
        return addVar;
    }

     /*
    modify order
    @ return  0 = don´t exist nodes
    @ return  1 = the new destiny and the origin is the same
    @ return  2 = the user is not suitable for this type of merchandise
    @ return  3 = the order was modify
     */
    public int Modify(int id, double itemWeight, User user, Vertex reciver, Node aux) {
        if (root == null) {
            return modVar = 0;
        } else {
            if (id == aux.getId()) {
                if (reciver != aux.getSender()) {
                    if (itemWeight < 4) {
                        if (user.getLicense().equals(B1)) {
                            aux.setItemWeight(itemWeight);
                            aux.setReceiver(reciver);
                            aux.setUser(user);
                            return modVar = 3;
                        }
                    } else if (itemWeight < 8) {
                        if (user.getLicense().equals(B2)) {
                            aux.setItemWeight(itemWeight);
                            aux.setReceiver(reciver);
                            aux.setUser(user);
                            return modVar = 3;
                        }
                    } else {
                        if (user.getLicense().equals(B3) || user.getLicense().equals(B4)) {
                            aux.setItemWeight(itemWeight);
                            aux.setReceiver(reciver);
                            aux.setUser(user);
                            return modVar = 3;
                        }
                    }
                    return modVar = 2;
                }
                return modVar = 1;
            } else {
                if (id < aux.getId()) {
                    if (aux.getIzq() == null) {
                        return modVar = 0;
                    } else {
                        Modify(id, itemWeight, user, reciver, aux.getIzq());
                    }
                } else {
                    if (aux.getDer() == null) {
                        return modVar = 0;
                    } else {
                        Modify(id, itemWeight, user, reciver, aux.getDer());
                    }
                }
            }
        }
        return modVar;
    }
    
    public boolean Delete(Node aux, int id){
        if (id == root.getId()) {
            if ((root.getDer() == null) && (root.getIzq() == null)) {
                root = null;
                return true;
            }
            if (root.getDer() == null) {
                root.setIzq(null);
                return true;
            }
            if (root.getIzq() == null) {
                root.setDer(null);
                return true;
            }
            aux = root.getIzq();
            if(aux.getDer() == null){
                aux.setDer(root.getDer());
                root = aux;
                return true;
            }
            while(aux.getDer() != null){
                aux = aux.getDer();
            }
        }
        Node ant = aux;
        while(aux != null){
            if(aux.getId() == id){
                break;
            }
            if(aux.getId() < id){
                ant = aux;
                aux = aux.getDer();
            }else{
                ant = aux;
                aux = aux.getIzq();
            }
        }
        if(aux == null){
            return false;
        }
        if(aux.getIzq() == null && aux.getDer() == null){
            if(ant.getId() < aux.getId()){
                ant.setDer(null);
                return true;
            }
            ant.setIzq(null);
            return true;
        }
        if(aux.getIzq() == null){
            if(ant.getId() < aux.getId()){
                ant.setDer(aux.getDer());
                return true;
            }
            ant.setIzq(aux.getDer());
            return true;
        }
        if(aux.getDer() == null){
            if(ant.getId() < aux.getId()){
                ant.setDer(aux.getIzq());
                return true;
            }
            ant.setIzq(aux.getIzq());
            return true;
        }
        Node node = aux.getIzq();
        if(node.getDer() == null){
            node.setDer(aux.getDer());
            if(ant.getId() < aux.getId()){
                ant.setDer(node);
                return true;
            }
            ant.setIzq(node);
            return true;
        }
        return false;
    }

    public void addComboID(Node aux, JComboBox combo) {
        if (aux == null) {
            return;
        }
        addComboID(aux.getIzq(), combo);
        combo.addItem(aux.getId());
        addComboID(aux.getDer(), combo);
    }
    
    public void Print( Node aux, DefaultListModel listModel){
       if(aux == null){
            return;
        }
        Print(aux.getIzq(), listModel);
        listModel.addElement("Punto de salida: " + aux.getSender().getName());
        listModel.addElement("Punto de llegada: " + aux.getReceiver().getName());
        listModel.addElement("Peso de la mercancia: " + aux.getItemWeight());
        listModel.addElement("Usuario: " + aux.getUser().getName());
        listModel.addElement("===============================================" );
        Print(aux.getDer(), listModel);
    }
}
