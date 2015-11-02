/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package treasure.ihm.component;

import java.awt.Color;
import javax.swing.plaf.basic.BasicProgressBarUI;

/**
 * Classe permettant de redéfinir le "Look and Feel" de la barre de progression
 * @author Boubacar
 */
public class MyProgressBarUI extends BasicProgressBarUI {

    public MyProgressBarUI() {
        super();
    }
    
    @Override
    protected Color getSelectionBackground() { 
        return Color.black; 
    }
    @Override
    protected Color getSelectionForeground() { 
        return Color.black; 
    }

}
