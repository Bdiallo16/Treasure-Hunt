/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package treasure.ihm.exceptions;

import javax.swing.JOptionPane;

/**
 * Exception qui est déclenchée lorsque le jeu est gagné
 * @author Boubacar
 */
public class WinEvent extends Exception{
    public WinEvent(){
        
    }
    /*
    *Message d'alerte indiquant que le jeu est gagné 
    */
    public void showPopMessage(){
        JOptionPane.showMessageDialog(null,"Vous avez Gagné");
    }
    
    public static void showWinMessage(){
        JOptionPane.showMessageDialog(null,"Vous avez Gagné");
    }
}
