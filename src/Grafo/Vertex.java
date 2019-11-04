/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Grafo;

/**
 *
 * @author DanielR
 */
public class Vertex {
    
    private String name;
    private Vertex sigV;
    private Vertex antV;
    private Arc sigA;

    public Vertex(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vertex getSigV() {
        return sigV;
    }

    public void setSigV(Vertex sigV) {
        this.sigV = sigV;
    }

    public Vertex getAntV() {
        return antV;
    }

    public void setAntV(Vertex antV) {
        this.antV = antV;
    }

    public Arc getSigA() {
        return sigA;
    }

    public void setSigA(Arc sigA) {
        this.sigA = sigA;
    }
    
}
