/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package treasure.ihm.component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.UIManager;
import treasure.model.Case;
import treasure.model.Grid;

/**
 * Composant graphique représentant la grille de jeu.
 * 
 * @author Boubacar
 */
public class GridView extends JPanel{
    
    
    // GRILLE & CASES
    private Grid g;
    private ArrayList<CaseView> cases;
    
    // THEME
    private static Color backgroundColor = new Color(102,153,255);
    private static Color borderColor = new Color(204,204,255);
    private static Color selectionColor = new Color(0,0,0);
    private static Color alreadyViewColor = Color.GRAY;
    private static Color treasureColor = Color.YELLOW;
    // Taille des cases
    private final int caseSize = 40;
    
    /**
     * Constructeur de la grille.
     * @param l nombre de ligne de la grille
     * @param c nombre de colonne de la grille
     */
    public GridView(int l, int c){
        super();
        this.setPreferredSize(new Dimension(caseSize*c,caseSize*l));
        this.setLayout(new GridLayout(l,c));
        cases = new ArrayList<CaseView>();
        g = new Grid(l,c);
        initGrid();
    }
    
   /**
    * Renvoie une case avec les coordonnées de la case qui contient le trésor
    * @return les coordonnées de la case qui contient le trésor 
    */
    public Case getTreasure(){
        return g.getTreasure();
    }
    
    
    /**
     * Renvoie la distance maximale entre la case et le trésor
     * @param l ligne d'une case
     * @param c colonne d'une case
     * @return distance maximale entre la case et le trésor MAX(|| l - trésor.l|| , || c - trésor.c ||)
     */
    public int getHints(int l, int c){
        return g.getHints(l, c);
    }
    
    /**
     * Modifie la couleur du trésor
     * @param c nouvelle couleur
     */
    public static void setTreasureColor(Color c){
        treasureColor = c;
    }
    
    /**
     * Obtient la couleur du trésor
     * @return la couleur du trésor
     */
    public static Color getTreasureColor(){
        return treasureColor;
    }
    /**
     * Modifie la couleur d'une case déjà vue.
     * @param c nouvelle couleur
     */
    public static void setAlreadyViewColor(Color c){
        alreadyViewColor = c;
    }
    /**
     * Renvoie la couleur d'une case déjà vue
     * @return la couleur d'une case déjà vue
     */
    public static Color getAlreadyViewColor(){
        return alreadyViewColor;
    }
    /**
     * Modifie la couleur de fond des cases
     * @param c nouvelle couleur
     */
    public static void setBackgroundColor(Color c){
        backgroundColor = c;
    }
    /**
     * Modifie la couleur des bordures des cases
     * @param c la nouvelle couleur
     */
    public static void setBorderColor(Color c){
        borderColor = c;
    }
    /**
     * Renvoie la couleur de fond des cases
     * @return la couleur de fond des cases
     */
    public static Color getBackgroundColor(){
        return backgroundColor;
    }
    
    /**
     * Renvoie la couleur des bordures des cases
     * @return la couleur des bordures des cases
     */
    public static Color getBorderColor(){
        return borderColor;
    }
    
    /**
     * Renvoie la couleur des bordures de la case sélectionnée
     * @return la couleur des bordures de la case sélectionnée
     */
    public static Color getSelectionColor(){
        return selectionColor;
    }
    
    /**
     * Modifie la couleur des bordures de la case sélectionnée
     * @param c la nouvelle couleur
     */
    public static void setSelectionColor(Color c){
        selectionColor = c;
    }
    
    /**
     * Initialise la grille de jeu
     */
    private void initGrid(){
        
        // mélange le trésor
        g.shuffle();
        
        // Met à jour la grille graphique
        this.removeAll();
        cases.clear();
        
        int l = g.getL();
        int c = g.getC();
        CaseView caseview;
        for(int i=0; i < l; i++){
            for(int j=0; j < c; j++){
                caseview = new CaseView(g.getCase(i, j));
                this.add(caseview);
                cases.add(caseview);
            }
        }
    }
    
    /**
     * Met à jour le thème de la grille
     */
    public void updateTheme(){
        for(CaseView c : cases){
            c.setBgColor();
            c.setBorderColor();
        }
    }
    /**
     * Permet de réinitialiser la grille pour commencer une nouvelle partie
     */
    public void reload(){
        initGrid();
    }
    
    /**
     * Passe le focus à la case de la ligne suivante
     * @param l ligne de la case actuelle
     * @param c colonne de la case actuelle
     */
    public void nextFocusRow(int l, int c){
        l = l+1;
        int index = (((l)*g.getL())+c)%cases.size();
        cases.get(index).requestFocus();
    }
    
    /**
     * Passe le focus à la case de la ligne précédente
     * @param l ligne de la case actuelle
     * @param c colonne de la case actuelle
     */
    public void previousFocusRow(int l, int c){
        
        l = l-1;
        l = (l<0)? l+g.getL() : l ;
        int index = (((l)*g.getL())+c)%cases.size();
        try{
            cases.get(index).requestFocus();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
