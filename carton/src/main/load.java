/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import com.formdev.flatlaf.FlatLightLaf;


/**
 *
 * @author home
 */
public class load {
    public static void main(String[] args) throws Exception{
        FlatLightLaf.setup();
        Loading l = new Loading();
        l.setVisible(true);
        main m = new main();
        m.setVisible(false);
        
        try {
            for (int x = 0; x < 100; x++) 
            {
             Thread.sleep(10);
             l.jLabel1.setText(Integer.toString(x)+"%");
             l.jProgressBar1.setValue(x);
             
                if (x == 99) {
                    l.setVisible(false);
                    m.setVisible(true);
                    
                }
            }
        } catch (Exception e) {
        }
    }
}
