/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HashTable;

import Enums.Licenses;
import javafx.scene.control.ComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author DanielR
 */
public class HashMethods {
    
    private final int size = 13;
    
    private User table[];
    
    /**
     * Constructor method
     */
    public HashMethods(){
       this.table = new User[size];
    }
    
    /**
     * generate new hash key
     * @param number user id to generate key
     * @return hash key.
     */
    private int hash(int number){
        return (number & 0xfffffff)% this.size;
    }
    
    /**
     * Insert user in table
     * @param user user to insert
     * @return  TRUE if inserted or False if not inserted.
     */
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
    
    /**
     * Search user by Id
     * @param number id to search in list.
     * @return Object User if is found or NULL if not found.
     */
    public User get(int number){
        int key = this.hash(number);
        
        if(this.table[key] == null){
            return null;
        }
        
        User aux = this.table[key];
        
        for (;aux != null; aux = aux.Next()){
            if(aux.getId() == number)
                break;
        }
        
        return aux;
       
    }
    /**
     * Print HashTable in console
     */
    public void print() {
        for (int i = 0; i < this.table.length; i++) {
            System.out.print("Indice: " + i + "[");
            for (User aux = this.table[i]; aux != null; aux = aux.Next()) {
                System.out.print(aux.getId() + ",");
            }
            System.out.print("]\n");
        }

    }

    public void print(DefaultListModel listModel) {
        for (int i = 0; i < this.table.length; i++) {
            for (User aux = this.table[i]; aux != null; aux = aux.Next()) {
                listModel.addElement("Nombre: " + aux.getName());
                listModel.addElement("Identificacion: " + aux.getId());
                listModel.addElement("Tipo de licencia: " + aux.getLicense());
                listModel.addElement("==================================");
            }
        }

    }
    
    /**
     * Create a new Table model with all users.
     * @param model Table model to insert data.
     */
    public void getModel(DefaultTableModel model){
        model.setRowCount(0);
        for (int i = 0; i < this.table.length; i++) {
            for (User aux = this.table[i]; aux != null; aux = aux.Next()) {
                Object[] row = new Object[3];
                row[0] = aux.getId();
                row[1] = aux.getName();
                row[2] = aux.getLicense();
                model.addRow(row);
            }
        }

    }

    /**
     * Create a new JComboBox with all users.
     *
     * @return JComboBox with users .
     */
    public void loadComboBox(JComboBox combo) {
        for (int i = 0; i < this.table.length; i++) {
            for (User aux = this.table[i]; aux != null; aux = aux.Next()) {
                combo.addItem("Usuario:  " + aux.getName() + " con licencia  " + aux.getLicense() + ", identificacion " + aux.getId());
            }
        }
    }
    
    public void addComboLicenses(JComboBox combo){
        for (Licenses type : Licenses.values()) {
            combo.addItem(type.name());
        }
        
    }

}
