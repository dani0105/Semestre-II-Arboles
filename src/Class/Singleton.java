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
    private TreeMethods orders;
    
    private Singleton (){
      this.map = new GraphMethods();
      this.orders = new TreeMethods();
      this.users = new HashMethods();
      
      this.map.add("Santa Clara", 10, 10);
      this.map.add("Florencia", 100, 10);
      this.map.add("Ciudad Quesada", 100, 100);
      
      this.map.add("Aguas Zarcas", 200, 100);
      this.map.add("Pital", 200, 10);
      this.map.add("Venecia", 300, 100);
      
      this.map.add("Santa Clara", "Florencia", 20, 40, 60, 2.5F );
      this.map.add("Florencia", "Ciudad Quesada", 20, 40, 60, 2.5F);
      this.map.add("Ciudad Qesada", "Aguas Zarcas", 20, 40, 60, 2.5F);
      this.map.add("Aguas Zarcas", "Pital", 20, 40, 60, 2.5F);
      this.map.add("Aguas Zarcas", "Venecia", 20, 40, 60, 2.5F);
      
      
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
    
    public TreeMethods getTreeMethods(){
        return this.orders;
    }

    public HashMethods getUsers() {
        return this.users;
    }
    
    
    
}
