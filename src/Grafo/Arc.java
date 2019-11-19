/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Grafo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Dimension2D;
import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author DanielR
 */
public class Arc {
    
    private final Color  COLOR = Color.BLACK;
    
    public Arc sigA;
    public Arc antA;
    public Vertex destination;
    
    private boolean isPath;
   
    private float maxWeight;
    private float distance;
    private float time;
    private float maxVelocity;

    public Arc(float maxWeight, float distance, float maxVelocity, float time){
        this.maxWeight = maxWeight;
        this.distance = distance;
        this.maxVelocity = maxVelocity;
        this.time = time;
    }

    /**
     * Draw line from origin vertex to destination vertex
     * @param g2d Canvas graphics
     * @param origin Origin vertex
     */
    public void draw(Graphics2D g2d, Vertex origin){
        g2d.setColor(COLOR);
        
        Dimension2D dimension = origin.getDimension2D();
        int width = (int) dimension.getWidth()/2;
        int height = (int) dimension.getHeight()/2;
        
        g2d.drawLine(origin.X()+width, origin.Y()+height, this.destination.X()+width, this.destination.Y()+height);
        
    }

    public boolean isIsPath() {
        return isPath;
    }

    public void setIsPath(boolean isPath) {
        this.isPath = isPath;
    }
    
    
    public Arc getSigA() {
        return sigA;
    }

    public void setSigA(Arc sigA) {
        this.sigA = sigA;
    }

  
    

    public Vertex getDestination() {
        return destination;
    }

    public void setDestination(Vertex destination) {
        this.destination = destination;
    }

    public float getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(float maxWeight) {
        this.maxWeight = maxWeight;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public float getMaxVelocity() {
        return maxVelocity;
    }

    public void setMaxVelocity(float maxVelocity) {
        this.maxVelocity = maxVelocity;
    }
    
    
}
