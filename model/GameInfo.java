/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package treasure.model;

/**
 * Représentation des données d'une partie
 * @author Boubacar
 */
public class GameInfo {
    
    /**
     * Nom du joueur
     */
    private String player;
    /**
     * La position du trésor
     */
    private Case posTreasure;
    /**
     * Nombre de coups joués
     */
    private int hits;
    /**
     * Indique le résultat de la partie
     */
    private String state;
    
    /**
     * Numéro de la partie
     */
    private int numPartie;
    
    /**
     * Constructeur
     * @param n nom du joueur
     * @param treasure case contenant le trésor
     * @param hit nombre de coups joués
     * @param win si la partie a été gagnée
     */
    public GameInfo(String n, Case treasure, int hit, boolean win){
        player = n;
        posTreasure = treasure;
        hits = hit;
        state = (win)? "Gagné":"Perdu";
    }
    
    public void setNumPartie(int i){
        numPartie = i;
    }
    /*
    *Affichage du numéro de la partie, du pseudo du joueur, la position du trésor,le nombre de coups et le résultat
    */
    @Override
    public String toString(){
        return "Partie "+numPartie+" , Joueur : "+player+" , Position du Trésor : "+posTreasure.toString()+" , Nombre de coups : "+hits+" , Résultat : "+state;
    }
    
}
