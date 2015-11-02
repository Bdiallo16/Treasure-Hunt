/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package treasure.ihm.component;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import treasure.ihm.component.GridView;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import treasure.ihm.controller.CaseListener;
import treasure.ihm.controller.KeyboardListener;
import treasure.ihm.exceptions.WinEvent;
import treasure.model.Case;

/**
 * Composant graphique représentant une case de la grille
 * @author Boubacar
 */
public class CaseView extends JButton implements FocusListener {
    
    
    private final Case _case;
    private static final int thickness = 2;
    
    /**
     * Constructeur de la case
     * @param c objet de type case
     */
    public CaseView(Case c){
        super();
        this.setOpaque(true);
        this.setBackground(GridView.getBackgroundColor());
        this.setBorder(BorderFactory.createLineBorder(GridView.getBorderColor(), thickness));
        //this.setBorderPainted(false);
        this.addActionListener(new CaseListener());
        this.addKeyListener(new KeyboardListener());
        this.addFocusListener(this);
        _case = c;
    }
    
    /**
     * Modifie la couleur de fond de la case.
     */
    public void setBgColor(){
        if(_case.hasTreasure() && _case.isViewed()){
            this.setBackground(GridView.getTreasureColor());
        }else if(_case.isViewed()){
            this.setBackground(GridView.getAlreadyViewColor());
        }else{
            this.setBackground(GridView.getBackgroundColor());
        }
    }
    /**
     * Modifie la couleur des bordures
     */
    public void setBorderColor(){
        this.setBorder(BorderFactory.createLineBorder(GridView.getBorderColor(), thickness));
    }
    /**
     * Indique à la case qu'elle a été cliquée.
     * @throws WinEvent exception levée lorsque la case contient le trésor.
     */
    public void clicked() throws WinEvent{
        _case.viewed();
        if(_case.hasTreasure())
        {
            this.setBackground(GridView.getTreasureColor());
            throw new WinEvent();
        }
        else{
            this.setBackground(GridView.getAlreadyViewColor());
        }
        
    }
    /**
     * Indique si la case a déjà été vue.
     * @return vrai si le joueur a déjà testé la case, faux sinon
     */
    public boolean isViewed(){
        return _case.isViewed();
    }
    
    /**
     * Renvoie la ligne de la case.
     * @return la ligne de la case
     */
    public int getLine(){
        return _case.getLine();
    }
    
    /**
     * Renvoie la colonne de la case
     * @return la colonne de la case
     */
    public int getColumn(){
        return _case.getColumn();
    }

    @Override
    public void focusGained(FocusEvent e) {
      this.setBorder(BorderFactory.createLineBorder(GridView.getSelectionColor(), thickness));
    }

    @Override
    public void focusLost(FocusEvent e) {
        setBorderColor();
    }
    
    
}
