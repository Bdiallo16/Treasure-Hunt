/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package treasure.ihm.controller;

import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JComponent;
import treasure.ihm.component.CaseView;
import treasure.ihm.component.GridView;

/**
 * Ecouteurs d'évènements du clavier pour gérer le déplacement (horizontal ou vertical) dans la grille avec les fleches du clavier
 * @author Boubacar
 */
public class KeyboardListener implements KeyListener{
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        CaseView c = (CaseView) e.getSource();
        /*
        *Gère l'evènement de la touche de la fleche gauche 
        */
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            c.transferFocusBackward();
        }
         /*
        *Gère l'evènement de la touche de la fleche droite 
        */
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            c.transferFocus();
        }
         /*
        *Gère l'evènement de la touche de la fleche montante 
        */
        else if(e.getKeyCode() == KeyEvent.VK_UP){
            
            GridView grid = (GridView) c.getParent();
            grid.previousFocusRow(c.getLine(),c.getColumn());
        }
         /*
        *Gère l'evènement de la touche de la fleche descendante 
        */
        else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            
            GridView grid = (GridView) c.getParent();
            grid.nextFocusRow(c.getLine(),c.getColumn());
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}
