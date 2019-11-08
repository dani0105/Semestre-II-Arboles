/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Class;

import Enums.Licenses;
import Grafo.GraphMethods;
import HashTable.HashMethods;
import HashTable.User;
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
    private TreeMethods ordrs;
    
    private Singleton (){
      this.map = new GraphMethods();
      
      this.map.add("A", 100, 100);
      this.map.add("B", 200, 200);
      this.map.add("C", 150, 200);
      
      this.map.add("A", "B", 20, 40, 60, LocalTime.of(1,30,0));
      this.map.add("B", "C", 20, 40, 60, LocalTime.of(1,30,0));
      
      this.users = new HashMethods();
      this.users.put(new User(1, "Daniel", Licenses.B1));
      this.users.put(new User(14, "Andres", Licenses.B2));
      this.users.put(new User(3, "Juan", Licenses.B3));
      this.users.put(new User(4, "Juan", Licenses.B3));
      this.users.put(new User(5, "Juan", Licenses.B3));
      this.users.print();
    }
    
    public static Singleton getInstance(){
        if(instance == null)
            return instance = new Singleton();
        else
            return instance;
    }
    
    public GraphMethods getGraphMethods(){
        return this.map;
    }
    
}
