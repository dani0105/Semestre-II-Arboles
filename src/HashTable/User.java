/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HashTable;

import Enums.Licenses;

/**
 *
 * @author DanielR
 */
public class User {

    private int id; // cedula
    private String name;
    private  Licenses license;
    
    private User next;
    
    /**
     * User constructor
     * @param id user id
     * @param name user name
     * @param license type user license. 
     */
    public User (int id,String name, Licenses license){
        this.id = id;
        this.name = name;
        this.license = license;
    }
    
    /**
     * get user id
     * @return Int with user id.
     * Ej: 2019076574.
     */
    public int getId(){
        return this.id;
    }
    
    /**
     * Get next user in list.
     * @return next user in list;
     */
    public User Next(){
        return this.next;
    }
    
    /**
     * set next user in list.
     * @param next next user in list;
     */
    public void Next(User next){
        this.next = next;
    }
    
    /**
     * get user name.
     * @return user name.
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * get type user license.
     * @return type license.
     */
    public Licenses getLicense(){
        return this.license;
    }
    
    /**
     * Set type user license.
     * @param license new user license.
     */
    public void setLicense(Licenses license){
        this.license = license;
    }
}
