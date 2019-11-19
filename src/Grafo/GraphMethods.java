package Grafo;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;


public class GraphMethods {

    public Vertex graph;

    private String routC = "";
    private float min = 0;  
    private float totalTime = 0;
    private float totalDistance = 0;

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
    
    
    public Vertex search(String name){
        if(this.graph == null)
            return null;
        
        Vertex auxVertex = graph; 
        while(auxVertex != null){
            if(auxVertex.getName().equals(name)){
                return auxVertex;
            }
            auxVertex = auxVertex.getSigV();
        }
        return null;
    }

    public boolean add(String ori, String dest, float heavyvehicles, float distance, float maxVelocity, float time) {
        if (ori.equals(dest)) {
            return false;
        } else {
            Vertex origin = search(ori);
            Vertex destination = search(dest);
            if ((origin != null) && (destination != null)) {
                if (search(origin, destination) == null) {
                    Arc newArc = new Arc(heavyvehicles, distance, maxVelocity, time);
                    newArc.setDestination(destination);
                    if (origin.getSigA() == null) {
                        origin.setSigA(newArc);
                    } else {
                        newArc.setSigA(origin.getSigA());
                        origin.getSigA().setAntA(newArc);
                        origin.setSigA(newArc);
                    }
                    Arc reverse = new Arc(heavyvehicles, distance, maxVelocity, time);
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
                Arc auxA = search(destination, origin);
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

    public boolean Modify(Vertex origin,Vertex destiny, float heavy, float maxVelocity){
        Arc auxA = search(origin, destiny);
        if(auxA != null){
            Arc aux = search(destiny, origin);
            auxA.setMaxWeight(heavy);
            auxA.setMaxVelocity(maxVelocity);
            aux.setMaxWeight(heavy);
            aux.setMaxVelocity(maxVelocity);
            return true;
        }
        return false;
    }

    public void depth(Vertex vertex, DefaultListModel listModel) {
        if ((vertex == null) || (vertex.isBrand())) {
            return;
        } else {
            vertex.setBrand(true);
            Arc auxA = vertex.getSigA();
            while (auxA != null) {
                listModel.addElement("Origen: " + vertex.getName());
                listModel.addElement("Destino: " + auxA.getDestination().getName());
                listModel.addElement("Peso maximo " + auxA.getMaxWeight() + " de toneladas");
                listModel.addElement("Velocidad maxima: " + auxA.getMaxVelocity());
                listModel.addElement("Distancia: " + auxA.getDistance());
                listModel.addElement("Tiempo de traslado en horas: " + auxA.getTime());
                listModel.addElement("===================================================");
                depth(auxA.getDestination(), listModel);
                auxA = auxA.getSigA();
            }
        }
    }

    
    public void amplitude(Vertex vertex, DefaultListModel listModel) {
        if(vertex == null){
             listModel.addElement("   ");
        }else {
            Vertex aux = vertex;
            while (aux != null) {
                Arc auxA = aux.getSigA();
                while (auxA != null) {
                    listModel.addElement("Origen: " + aux.getName());
                    listModel.addElement("Destino: " + auxA.getDestination().getName());
                    listModel.addElement("Peso maximo " + auxA.getMaxWeight() + " de toneladas");
                    listModel.addElement("Velocidad maxima: " + auxA.getMaxVelocity());
                    listModel.addElement("Distancia: " + auxA.getDistance());
                    listModel.addElement("Tiempo de traslado en horas: " + auxA.getTime());
                    listModel.addElement("===================================================");
                    auxA = auxA.getSigA();
                }
                aux = aux.getSigV();
            }
        }
    }


     
    public void shortRouteByTime(Vertex origin, Vertex destiny,String rut, float time) {
         if ((origin == null) || (origin.isBrand())) {
            return;
        }
        if (origin == destiny) {
            System.out.println("Ruta: " + rut + destiny.getName());
            System.out.println("Con un tiempo de: " + time);
            System.out.println("La distancia recorrida es de " + totalDistance);

            if ((routC.equals("")) || (min > time)) {
                routC = rut + destiny.getName();
                min = time;
                totalDistance += origin.getSigA().getDistance();
            }           
            return;
        }
        origin.setBrand(true);
        Arc auxA = origin.getSigA();
        while (auxA != null) {
            shortRouteByDistance(auxA.getDestination(), destiny, rut +", "+ origin.getName(), time + auxA.getTime());
            auxA.setSigA(auxA);
        }
        origin.setBrand(false);

    }

    public void printBands(){
        for (Vertex aux = this.graph; aux !=null; aux= aux.getSigV()) {
            System.out.println(aux.getName()+":"+aux.getBrand());
        }
    }
    
    public void shortRouteByDistance(Vertex origin, Vertex destiny, String rut, float dist) {
        if ((origin == null) || (origin.isBrand())) {
            return;
        }
        if (origin == destiny) {
            System.out.println("Ruta: " + rut + destiny.getName());
            System.out.println("Con una distancia de: " + dist);
            System.out.println("El tiempo de traslado es de " + totalTime + " de horas");

            if ((routC.equals("")) || (min > dist)) {
                routC = rut + destiny.getName();
                min = dist;
                totalTime += origin.getSigA().getTime();
            }           
            return;
        }
        origin.setBrand(true);
        Arc auxA = origin.getSigA();
        while (auxA != null) {
            shortRouteByDistance(auxA.getDestination(), destiny, rut +", "+ origin.getName(), dist + auxA.getDistance());
            auxA.setSigA(auxA);
        }
        origin.setBrand(false);
    }
    public void addCombo(JComboBox combo){
          if (graph != null) {
            Vertex auxV = graph;
            while (auxV != null) {
                combo.addItem(auxV.getName());
                auxV = auxV.getSigV();
            }
        }
    }
    public void CleanBrand() {
        if (graph != null) {
            Vertex auxV = graph;
            while (auxV != null) {
                auxV.setBrand(false);
                auxV = auxV.getSigV();
            }
        }     
    }
   }
