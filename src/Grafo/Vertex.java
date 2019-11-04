/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Grafo;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Dimension2D;


/**
 *
 * @author DanielR
 */
public class Vertex {
    
    private final Color  COLOR = Color.GREEN;
    private final Dimension2D DIMENSIONS = new Dimension(40,40);
    
    private int x,y;
    private String name;
    private Vertex sigV;
    private Vertex antV;
    private Arc sigA;

    public Vertex(String name,int x,int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }
    
    
    public void draw(Graphics2D g2d){
        g2d.setColor(this.COLOR);
        g2d.fillOval(this.x, this.y, (int) this.DIMENSIONS.getWidth(), (int) this.DIMENSIONS.getHeight());
       
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
