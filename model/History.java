/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package treasure.model;

import java.util.ArrayList;

/**
 * Classe implémentant l'historique
 * @author Boubacar
 */
public class History {
    
    /**
     * Stocke les données de l'historique 
     */
    ArrayList<GameInfo> history;
    
    /**
     * Constructeur par défaut
     */
    public History(){
        history = new ArrayList();
    }
    
    /**
     * Ajoute une donnée à l'historique
     */
    public void add(GameInfo info){
        info.setNumPartie(history.size()+1);
        history.add(info);
    }
    
    /**
     * Récupère l'historique
     * @return l'historique
     */
    public ArrayList<GameInfo> get(){
        return history;
    }
    
}
