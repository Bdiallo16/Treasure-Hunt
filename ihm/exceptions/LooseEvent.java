/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package treasure.ihm.exceptions;

import javax.swing.JOptionPane;

/**
 * Exception déclenchée lorsque le jeu est perdu
 * @author Boubacar
 */
public class LooseEvent extends Exception{
    public LooseEvent(){
        
    }
     /*
    *Message d'alerte indiquant que le jeu est perdu 
    */
    public void showPopMessage(){
        JOptionPane.showMessageDialog(null,"Vous avez perdu...");
    }
    
    public static void showLoseMessage(){
        JOptionPane.showMessageDialog(null,"Vous avez perdu...");
    }
}
