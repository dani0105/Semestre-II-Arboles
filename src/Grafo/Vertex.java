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
    private boolean brand;

    public Vertex(String name, boolean brand) {
        this.name = name;
        this.brand = brand;
    }

    public boolean isBrand() {
        return brand;
    }

    public void setBrand(boolean brand) {
        this.brand = brand;
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
