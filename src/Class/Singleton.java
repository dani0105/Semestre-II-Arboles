/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Class;

import Grafo.GraphMethods;
import HashTable.HashMethods;
import Tree.TreeMethods;

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
        
    }
    
    public static Singleton getInstance(){
        if(instance == null)
            return instance = new Singleton();
        else
            return instance;
    }
    
}
