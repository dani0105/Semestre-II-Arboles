/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HashTable;

import javax.swing.table.DefaultTableModel;


/**
 *
 * @author DanielR
 */
public class HashMethods {
    
    private final int size = 13;
    
    private User table[];
    
    public HashMethods(){
       this.table = new User[size];
    }
    private int hash(int number){
        return (number & 0xfffffff)% this.size;
    }
    
    public boolean put(User user){
        int key = this.hash(user.getId());
        
        User aux = this.table[key];
        
        if(aux == null){
            this.table[key] = user;
        }else{
            for (;aux != null; aux = aux.Next()){
                if(aux.getId() == user.getId()){
                    return false;
                }
                if(aux.Next() == null){
                    aux.Next(user);
                    break;
                }
            }
        }
        return true;
    } 
    
    public void print(){
        for (int i = 0; i < this.table.length; i++) {
            System.out.print("Indice: "+i+"[");
            for (User aux = this.table[i]; aux != null; aux = aux.Next()) {
                System.out.print(aux.getId()+",");
            }
            System.out.print("]\n");
        }
         
    }
    
    public DefaultTableModel getModel(){
        DefaultTableModel model = new DefaultTableModel();
        for (int i = 0; i < this.table.length; i++) {
            for (User aux = this.table[i]; aux != null; aux = aux.Next()) {
                Object[] row =new Object[3];
                row[0] = aux.getId();
                row[1] = aux.getName();
                row[2] = aux.getLicense();
                model.addRow(row);
            }
        }
        return model;
    }
        
}
