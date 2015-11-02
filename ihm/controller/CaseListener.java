/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package treasure.ihm.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
import treasure.ihm.component.CaseView;
import treasure.ihm.GameView;
import treasure.ihm.exceptions.LooseEvent;
import treasure.ihm.exceptions.WinEvent;

/**
 * ActionListener qui est créé lorsque l'utilisateur clic sur une case de la grille.
 * @author Boubacar
 */
public class CaseListener implements ActionListener{

    
    @Override
    public void actionPerformed(ActionEvent e) {
        CaseView c = (CaseView) e.getSource();
        // Si la case n'a pas déjà été vue
        if(!c.isViewed()){
            // On récupère le GameView pour vérifier que la partie n'a pas déjà été gagnée ou perdue.
            try{
                GameView gV = (GameView) SwingUtilities.getRoot(c);
                // Si la partie n'est pas gagnée
                if(!gV.isWinner() && !gV.isLooser()){
                    try{
                        int hint = gV.refreshHint(c.getLine(), c.getColumn());
                        c.setText(Integer.toString(hint));
                        c.clicked();
                        //appel de la fonction gerant le nombre de coups
                        gV.hit();
                        
                    }catch(WinEvent win){
                        gV.win();
                        //appel de la fonction showPopMessage() pour afficher un popup indiquant que la partie est gagnée
                        win.showPopMessage();
                    }
                }else{
                    if(gV.isWinner())
                         //appel de la fonction showMessage() pour afficher un le message indiquant que la est gagnée
                        WinEvent.showWinMessage();
                    else
                        LooseEvent.showLoseMessage();
                }

            }catch(ClassCastException castError){
                System.out.println(castError.getMessage());
            }
        }
        
    }
    
    
    
}
