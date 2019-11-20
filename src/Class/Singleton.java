/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Class;

import Enums.Licenses;
import Grafo.GraphMethods;
import Grafo.Vertex;
import HashTable.HashMethods;
import HashTable.User;
import Tree.Node;
import Tree.TreeMethods;
import java.time.LocalTime;

/**
 *
 * @author DanielR
 */
public class Singleton {
    private static Singleton  instance;
    
    private HashMethods users;
    private GraphMethods map;
    private TreeMethods orders;
    
    private Singleton (){
      this.map = new GraphMethods();
      this.orders = new TreeMethods();
      this.users = new HashMethods();
      
      this.map.add("Santa Clara", 10, 50);
      this.map.add("Florencia", 120, 60);
      this.map.add("Ciudad Quesada", 125, 150);
      
      this.map.add("Aguas Zarcas", 250, 140);
        this.map.add("Pital", 260, 10);
        this.map.add("Venecia", 350, 150);

        //                                      Peso-KM-KM/H-Time 
        this.map.add("Santa Clara", "Florencia", 20, 8, 60, 2.5F);
        this.map.add("Florencia", "Ciudad Quesada", 20, 10, 40, 3f);
        this.map.add("Florencia", "Pital", 30, 60, 70, 4F);
        this.map.add("Ciudad Quesada", "Aguas Zarcas", 20, 24, 40, 2.5F);
        this.map.add("Aguas Zarcas", "Pital", 20, 20, 70, 1.5F);
        this.map.add("Aguas Zarcas", "Venecia", 24, 24, 65, 2.5F);
        this.map.add("Pital", "Venecia", 24, 24, 65, 2.5F);

        this.users.put(new User(1, "Daniel", Licenses.B1));
        this.users.put(new User(14, "Andres", Licenses.B2));
        this.users.put(new User(3, "House", Licenses.B3));
        this.users.put(new User(4, "Sebastian", Licenses.B3));
        this.users.put(new User(5, "Ismael", Licenses.B3));

    }

    public static Singleton getInstance() {
        if(instance == null)
            return instance = new Singleton();
        else
            return instance;
    }
    
    public GraphMethods getGraphMethods(){
        return this.map;
    }
    
    public TreeMethods getTreeMethods(){
        return this.orders;
    }

    public HashMethods getUsers() {
        return this.users;
    }
    
    
    
}
