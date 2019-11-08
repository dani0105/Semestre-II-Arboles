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
    private boolean brand;

    public Vertex(int x, int y, String name, boolean brand) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.brand = brand;
        this.x = x;
        this.y = y;
    }
  
    public boolean isBrand() {
        return brand;
    }

    public void setBrand(boolean brand) {
        this.brand = brand;
        }
    
    /**
     * This methods draw the vertex in canvas.
     * @param g2d Canvas graphics
     */
    public void draw(Graphics2D g2d){
        g2d.setColor(this.COLOR);
        g2d.fillOval(this.x, this.y, (int) this.DIMENSIONS.getWidth(), (int) this.DIMENSIONS.getHeight());  
        
        Arc aux = this.sigA;
        while(aux != null){
            System.out.println("Dibujando Arco desde "+this.name+" a "+aux.getDestination().getName());
            aux.draw(g2d, this);
            aux = aux.getSigA();
        }
        System.out.println("Siguiente\n");
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
    
    /**
     * X coordinate in the canvas
     * @return 
     */
    public int X(){
        return this.x;
    }
    
    /**
     * set new X coordinate.
     * @param X new coordinate
     */
    public void X(int X){
        this.x = X;
    }
    
    /**
     * Y coordinate in the canvas
     * @return 
     */
    public int Y(){
        return this.x;
    }
    
    /**
     * set new Y coordinate.
     * @param Y new coordinate
     */
    public void Y( int Y ){
        this.y= Y;
    }
    
    /**
     * dimensions of the object in the canvas
     * @return Dimension2D with width and long.
     */
    public Dimension2D getDimension2D(){
        return this.DIMENSIONS;
    }
    
    
}
