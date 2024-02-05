import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Recherche {
    HashMap<Integer,List> ferme = new HashMap<>();
    HashMap<Integer,List> ouvert = new HashMap<>() ;

    // Ajout de l'état initial à l'ensemble Ouvert

    While( !ouvert.isEmpty() && !estBut(ouvert.teteOuvert()) ){
        Etat etat = new Etat("etat",ouvert.teteOuvert(),0);
        ouvert.supprimerEtat(etat.getContenus());
        ferme.put(ferme.size()-1,etat.getContenus());
        for(Etat voisin : etat.getVoisins()){
            if(voisin.getContenus())
            ouvert.ajout(voisin.getContenus());
        }



    }
    //ALgo


    // Fonction pour calculer l'heuristique d'un état
    public static int heuristic(String etat) {
        // Implémentez votre fonction heuristique ici
        return 0; // Pour l'exemple, retourne simplement 0
        }
    public Boolean estBut(List ouvert){ return true; }
    // Fonction pour récupérer le meilleur état dans l'ensemble Ouvert
    /*public static State meilleur(PriorityQueue<State> ouvert) {
        return ouvert.peek();
        }*/

}