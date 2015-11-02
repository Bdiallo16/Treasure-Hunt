/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package treasure.model;

import java.awt.Color;
import java.util.Random;

/**
 * Représente la grille du jeu 
 * @author Boubacar
 */
public class Grid {
    
    /*
    *objet grid de type case
    */
    private Case[][] grid;
    /*
    *ligne et colonne du trésor à trouver
    */
    private int lineTreasure;
    private int colTreasure;
    /*
    *ligne et colonne de la case
    */
    private int l, c;
    private Random rand;
    
   /**
    * Constructeur
    * @param line nombre de lignes
    * @param column nombre de colonnes
    */
    public Grid(int line, int column){
        
        l = line;
        c = column;
        rand = new Random();
        shuffle();
    }
    
   /**
    * Positionne aléatoirement le trésor dans la grille 
    */
    public void shuffle(){
        grid = new Case[l][c];
        
        for(int i=0; i < l; i++){
            for(int j=0; j < c; j++){
                grid[i][j] = new Case(i,j);
            }
        }
        // Position du trésor
        lineTreasure = rand.nextInt(l);
        colTreasure = rand.nextInt(c); 
        
        grid[lineTreasure][colTreasure].giveTreasure();
        
    }
   
    /**
     * Renvoie la position du trésor
     * @return la position du trésor
     */
    public Case getTreasure(){
        return new Case(lineTreasure,colTreasure);
    }
    
    /**
     * Renvoie le nombre de lignes de la grille
     * @return le nombre de lignes de la grille
     */
    public int getL(){
        return l;
    }
    
    /**
     * Renvoie le nombre de colonnes de la grille
     * @return le nombre de colonnes de la grille
     */
    public int getC(){
        return c;
    }
    
   /**
    * Renvoie la distance entre les coordonnées de la case passée en paramètre et 
    * la case du trésor
    * @param l la ligne de la case choisie
    * @param c la colonne de la case choisie
    * @return la distance entre les 2
    */
    public int getHints(int l, int c){
        return Math.max(Math.abs(l-lineTreasure),Math.abs(c-colTreasure));
    }
    
    /**
     * Renvoie la case à la position ( i , j )
     * @param i ligne de la case voulue
     * @param j colonne de la case voulue
     * @return la case correspondante
     */
    public Case getCase(int i, int j){
        return grid[i][j];
    }
    
    
}
