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
 * @author binns
 */
public class Arc {
    
    private final Color  COLOR = Color.BLACK;
    
    private Arc sigA;
    private Arc antA;
    private Vertex destination;
    
    private boolean isPath;
   
    private float maxWeight;

    public Vertex destino;
  
    private float MaxWeight;
    private float MaxVelocity;
    private float distance;
    private float time;

    public Arc(float MaxWeight, float MaxVelocity, float distance, float time) {
        this.MaxWeight = MaxWeight;
        this.MaxVelocity = MaxVelocity;
        this.distance = distance;
        this.time = time;
    }

    public void draw(Graphics2D g2d, Vertex origin) {
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

        Dimension2D dimension = origin.getDimension2D();
        int width = (int) dimension.getWidth() / 2;
        int height = (int) dimension.getHeight() / 2;

        g2d.drawLine(origin.X() + width, origin.Y() + height, this.destino.X() + width, this.destino.Y() + height);
    }

    public float getMaxWeight() {
        return MaxWeight;
    }

    public void setMaxWeight(float MaxWeight) {
        this.MaxWeight = MaxWeight;
    }

    public float getMaxVelocity() {
        return MaxVelocity;
    }

    public void setMaxVelocity(float MaxVelocity) {
        this.MaxVelocity = MaxVelocity;
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

}
