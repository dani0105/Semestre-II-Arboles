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



    public boolean add(String name, int x, int y) {
        if (search(name) == null) {
            Vertex newVer = new Vertex(x, y, name, false);
            if (graph == null) {
                graph = newVer;
            } else {
                newVer.setSigV(graph);
                graph.setAntV(newVer);
                graph = newVer;
            }
            return true;
        }
        return false;
    }

    public Vertex search(String name) {
        if (graph != null) {
            Vertex auxV = graph;
            while (auxV.getSigV() != null) {
                if (auxV.getName().equals(name)) {
                    return auxV;
                }
                auxV = auxV.getSigV();
            }
        }
        return null;
    }

    public boolean add(String ori, String dest, int weight, double heavyvehicles, double distance, double maxVelocity) {
        if (ori.equals(dest)) {
            return false;
        } else {
            Vertex origin = search(ori);
            Vertex destination = search(dest);
            if ((origin != null) && (destination != null)) {
                if (search(origin, destination) == null) {
                    Arc newArc = new Arc(heavyvehicles, distance, maxVelocity);
                    newArc.setDestination(destination);
                    if (origin.getSigA() == null) {
                        origin.setSigA(newArc);
                    } else {
                        newArc.setSigA(origin.getSigA());
                        origin.getSigA().setAntA(newArc);
                        origin.setSigA(newArc);
                    }
                    Arc reverse = new Arc(heavyvehicles, distance, maxVelocity);
                    reverse.setDestination(origin);
                    if (destination.getSigA() == null) {
                        destination.setSigA(reverse);
                    } else {
                        reverse.setSigA(destination.getSigA());
                        destination.getSigA().setAntA(reverse);
                        destination.setSigA(reverse);
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
    }
    
    public Arc search(Vertex origin, Vertex destination) {
        if (graph != null && origin.getSigA() != null) {
            Arc aux = origin.getSigA();
            while (aux.getSigA() != null) {
                if (aux.getDestination() == destination) {
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
                Arc auxA = auxArc;
                if (auxArc == origin.getSigA()) {
                    origin.setSigA(auxArc.getSigA());
                    if (origin.getSigA() != null) {
                        auxArc.getSigA().setAntA(null);
                    }
                } else {
                    auxArc.getAntA().setSigA(auxArc.getSigA());
                    if (auxArc.getSigA() != null) {
                        auxArc.getSigA().setAntA(auxArc.getAntA());
                    }
                }
                if (auxA == destination.getSigA()) {
                    destination.setSigA(auxA.getSigA());
                    if (destination.getSigA() != null) {
                        auxA.getSigA().setAntA(null);
                    }
                    return true;
                }
                auxA.getAntA().setSigA(auxA.getSigA());
                if(auxA.getSigA() != null){
                    auxA.getSigA().setAntA(auxA.getAntA());
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

    public boolean Modify(String vertex, String newName) {
        Vertex auxV = search(vertex);
        if (auxV != null) {
            auxV.setName(newName);
            return true;
        }
        return false;
    }

    public boolean Modify(Vertex origin,Vertex destiny, double heavy, double maxVelocity, double distance){
        Arc auxA = search(origin, destiny);
        if(auxA != null){
            Arc aux = search(destiny, origin);
            auxA.setHeavyvehicles(heavy);
            auxA.setMaxVelocity(maxVelocity);
            auxA.setDistance(distance);
            aux.setHeavyvehicles(heavy);
            aux.setDistance(distance);
            aux.setMaxVelocity(maxVelocity);
            return true;
        }
        return false;
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
    
    
    public void amplitude(Vertex vertex) {
        if(vertex == null){
            
        }else{
            Vertex aux = vertex;
            while(aux != null){
                Arc arc = aux.getSigA();
                while(arc != null){
                    
                    arc = arc.getSigA();
                }
                aux = aux.getSigV();
            }
        }
    }
    
   
    /* 
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
*/
   ArrayList<Vertex> saveVertex = new ArrayList<>();
    public void shortRouteByDistance(Vertex Ori, Vertex Dest, double vehicleweight) {
        if (Dest.isBrand()) {
            return;
        } else {
            if (Ori.getSigA() != null) {
                Arc arc = Ori.getSigA();
                while (arc != null) {
                    if (arc.getHeavyvehicles() < vehicleweight) {
                       
                    }
                    arc = arc.getSigA();
                }
            }
        }
    }

}

