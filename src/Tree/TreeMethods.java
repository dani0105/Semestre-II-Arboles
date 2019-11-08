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
public class TreeMethods {

    public Node root;
    private boolean addVar;
    private Node modVar;

    public boolean add(int id, double itemWeight, User sigU, Vertex sender, Vertex receiver, Node aux) {
        Node node = new Node(id, itemWeight, sigU, sender, receiver);
        if (root == null) {
            return addVar = false;
        } else {
            if (id == aux.getId()) {
                return addVar = false;
            } else {
                if (id < aux.getId()) {
                    if (aux.getIzq() == null) {
                        aux.setIzq(node);
                        return addVar = true;
                    } else {
                        add(id, itemWeight, sigU, sender, receiver, aux.getIzq());
                    }
                } else {
                    if (aux.getDer() == null) {
                        aux.setDer(node);
                        return addVar = true;
                    } else {
                        add(id, itemWeight, sigU, sender, receiver, aux.getDer());
                    }
                }
            }
        }
        return addVar;
    }
   
    public Node Modify(int id, double itemWeight, User sigU, Vertex sender, Node aux) {
        if (root == null) {
            return modVar = null;
        } else {
            if (id == aux.getId()) {
                aux.setItemWeight(itemWeight);
                aux.setReceiver(sender);
                aux.setSigU(sigU);
                return modVar = aux;
            } else {
                if (id < aux.getId()) {
                    if (aux.getIzq() == null) {
                        return modVar = null;
                    } else {
                        Modify(id, itemWeight, sigU, sender, aux.getIzq());
                    }
                } else {
                    if (aux.getDer() == null) {
                        return modVar = null;
                    } else {
                        Modify(id, itemWeight, sigU, sender, aux.getDer());
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
}
