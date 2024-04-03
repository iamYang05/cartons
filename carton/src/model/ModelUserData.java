/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author home
 */
public class ModelUserData {

    /**
     * @return the getUsername
     */
    public String getGetUsername() {
        return getUsername;
    }

    /**
     * @param getUsername the getUsername to set
     */
    public void setGetUsername(String getUsername) {
        this.getUsername = getUsername;
    }

    /**
     * @return the getPassword
     */
    public char [] getGetPassword() {
        return getPassword;
    }

    /**
     * @param getPassword the getPassword to set
     */
    public void setGetPassword(char [] getPassword) {
        this.getPassword = getPassword;
    }
    
    public ModelUserData( String userName, char [] password){
        this.getUsername= userName;
        this.getPassword= password;
    }
    
    public ModelUserData(){
    
    }
    
    private String getUsername;
    private char [] getPassword;
    
    
    
}
