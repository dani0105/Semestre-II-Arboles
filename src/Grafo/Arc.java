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
public class Arc {

    private Arc sigA;
    private Arc antA;
    private Vertex destination;
    private double heavyvehicles;
    private double distance;
    private double maxVelocity;

    public Arc(double heavyvehicles, double distance, double maxVelocity){
        this.heavyvehicles = heavyvehicles;
        this.distance = distance;
        this.maxVelocity = maxVelocity;
    }

    public Arc getSigA() {
        return sigA;
    }

    public void setSigA(Arc sigA) {
        this.sigA = sigA;
    }

    public Arc getAntA() {
        return antA;
    }

    public void setAntA(Arc antA) {
        this.antA = antA;
    }

    public Vertex getDestination() {
        return destination;
    }

    public void setDestination(Vertex destination) {
        this.destination = destination;
    }

    public double getHeavyvehicles() {
        return heavyvehicles;
    }

    public void setHeavyvehicles(double heavyvehicles) {
        this.heavyvehicles = heavyvehicles;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
    
    public double getMaxVelocity() {
        return maxVelocity;
    }

    public void setMaxVelocity(double maxVelocity) {
        this.maxVelocity = maxVelocity;
    }
    
    
}
