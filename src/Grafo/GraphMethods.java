/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Grafo;

import java.util.ArrayList;

/**
 *
 * @author DanielR
 */


public class GraphMethods {
    
    public Vertex graph;
    public Vertex origin;
    public double original = 0;

    public boolean add(String name){
        if(search(name) == null){
            Vertex newVer = new Vertex(name, false);
            if(graph == null){
                graph = newVer;
            }else{
              newVer.setSigV(graph);
              graph.setAntV(newVer);
              graph = newVer;
            }
            return true;
        }
        return false;
    }
    
    public Vertex search(String name){
        Vertex auxV = graph; 
        while(auxV.getSigV() != null){
            if(auxV.getName().equals(name)){
                return auxV;
            }
            auxV = auxV.getSigV();
        }
        return null;
    }
    
    public boolean add(String ori, String dest, int weight, double heavyvehicles, double distance, double maxVelocity){
        Vertex origin = search(ori);
        Vertex destination = search(dest);
        if((origin != null) && (destination != null)){
            if(search(origin, destination) == null){
                Arc newArc = new Arc(weight, heavyvehicles, distance, maxVelocity);
                newArc.setDestination(destination);
                if(origin.getSigA() == null){
                    origin.setSigA(newArc);
                }else{
                    newArc.setSigA(origin.getSigA());
                    origin.getSigA().setAntA(newArc);
                    origin.setSigA(newArc);
                }
                 return true;      
            }
            return false;
        }
        return false;
    }
    
    public Arc search(Vertex origin, Vertex destination){
        if(origin.getSigA() != null){
            Arc aux = origin.getSigA();
            while(aux.getSigA() != null){
                if(aux.getDestination() == destination){
                    return aux;
                }
                aux = aux.getSigA();
            }
        }
        return null;
    }

    public boolean delete(Vertex origin, Vertex destination) {
        if (graph == null) {
            return false;
        } else {
            Arc auxArc = search(origin, destination);
            if (auxArc != null) {
                if (auxArc == origin.getSigA()) {
                    origin.setSigA(auxArc.getSigA());
                    if (origin.getSigA() != null) {
                        auxArc.getSigA().setAntA(null);
                    }
                    return true;
                }
                auxArc.getAntA().setSigA(auxArc.getSigA());
                if (auxArc.getSigA() != null) {
                    auxArc.getSigA().setAntA(auxArc.getAntA());
                }
                return true;
            }
            return false;
        }
    }
    
    public boolean delete(Vertex vertex){
        if(graph == null){
            return false;
        }else{
            Vertex auxV = graph; 
            while(auxV != null){
                Arc auxA = auxV.getSigA();
                while(auxA != null){
                    if(auxA.getDestination() == vertex){
                        delete(auxV, vertex);
                    }
                    auxA = auxA.getSigA();
                }
                auxV = auxV.getSigV();
            }
            if(vertex == graph){
                graph = vertex.getSigV();
                if( vertex.getSigV() != null){
                     vertex.getSigV().setAntV(null);
                }
                return true;
            }
            vertex.getAntV().setSigV(auxV.getSigV());
            if (vertex.getSigV() != null) {
                vertex.getSigV().setAntV(auxV.getAntV());
            }
            return true;
        }
    }

    public void depth(Vertex vertex) {
        if ((vertex == null) && (vertex.isBrand())) {
            return;
        } else {
            vertex.setBrand(true);
            Arc auxA = vertex.getSigA();
            while (auxA != null) {

                depth(auxA.getDestination());
                auxA = auxA.getSigA();
            }
        }
    }
    
    /*
    public void amplitude() {

    }

    

    public void shortRouteByTime(Vertex origin, Vertex destiny, double vehicleweight) {
        Vertex min = null;
        double time = Double.MAX_VALUE;
        double totalTime = 0;
        double totalDistance = 0;
        Arc auxA = origin.getSigA();
        while (auxA != null) {
            if (auxA.getDestination() == destiny) {
                auxA.getDestination().setBrand(true);
                break;
            }
            if (auxA.getTime() < time) {
                if (vehicleweight < auxA.getHeavyvehicles()) {
                    auxA.getDestination().setBrand(true);
                    totalTime += time;
                    totalDistance += auxA.getDistance();
                    min = auxA.getDestination();
                    auxA = min.getSigA();
                    time = auxA.getTime();
                }
            }
            auxA = auxA.getSigA();
        }
    }

    public void shortRouteByDistance(Vertex verOri, Vertex verDest, double vehicleweight, double temp, Vertex antV, Arc sigA) {
        verOri.setBrand(true);
        //ArrayList<Arc> list = new ArrayList<>();
        // Vertex auxV = verOri;
        if (original != temp) {
            

        }
        Arc auxA = sigA;
        while (auxA != null) {
            if (vehicleweight < auxA.getHeavyvehicles()) {
                if (!auxA.getDestination().isBrand()) {
                    temp += auxA.getDistance();
                    shortRouteByDistance(verOri, verDest, vehicleweight, temp, verOri, auxA.getSigA());
                }
            } else {
                auxA.getDestination().setBrand(true);
                shortRouteByDistance(verOri, verDest, vehicleweight, temp, verOri, auxA.getSigA());
            }
            auxA = auxA.getSigA();
        }
    }
*/

}
