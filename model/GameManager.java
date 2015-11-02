/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package treasure.model;

import java.util.ArrayList;

/**
 * Classe qui concentre toutes les données liées au jeu et qui persiste quelque soit l'état du jeu
 * @author Boubacar
 */
public class GameManager {
    
    /**
     * Historique du jeu
     */
    private static History historique = null;
    
    /**
     * Nom du joueur
     */
    private static String player = "";
    
    /**
     * Ajoute des données à l'historique
     */
    public static void addHistory(GameInfo info){
        if(historique == null){
            historique = new History();
        }
        
        historique.add(info);
    }
    
    /**
     * Retourne l'historique
     * @return l'historique
     */
    public static ArrayList getHistory(){
        if(historique == null){
            return new ArrayList();
        }else{
            return historique.get();
        }
    }
    
    /**
     * Modifie le nom du joueur
     * @param n le nom du joueur
     */
    public static void newPlayer(String n){
        player = n;
    }
    /**
     * Envoie le nom du joueur
     * @return le nom du joueur
     */
    public static String getPlayer(){
        return player;
    }
    
}
