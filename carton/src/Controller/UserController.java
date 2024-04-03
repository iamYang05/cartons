/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import model.ModelUserData;

/**
 *
 * @author home
 */
public class UserController {
    forlogin_signin DAO;
    
        public UserController(){
            this.DAO = new forlogin_signin();
        }
        
        public boolean registerUser(ModelUserData data){
            String encryppass = DAO.Encryp(new String(data.getGetPassword()));
            data.setGetPassword(encryppass.toCharArray());
        return DAO.addUserDatabase(data);
        }
        public ModelUserData Login(ModelUserData data){
            String encryppass = DAO.Encryp(new String (data.getGetPassword()));
            data.setGetPassword(encryppass.toCharArray());
        return this.DAO.login(data);
        }
}
