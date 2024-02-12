import java.util.*;

public class RechercheEnProfondeur {
    List<Etat> ferme = new ArrayList<>();
    Stack<Etat> ouvert = new Stack<>() ;

    public void heuristic() {
        Etat etat;
        //Initialisation de ferme
        ferme = null;
        //Ajout de l'état initial à l'ensemble Ouvert
        ouvert.add(new Etat("initial",new ArrayList<>(Arrays.asList(0,0,0,0)),0));
        while( !ouvert.isEmpty() && !estBut(ouvert.peek()) ){
            etat = ouvert.peek();
            ouvert.remove(etat);
            ferme.add(etat);
            for(Etat voisin : etat.getVoisins()){
                if(!ferme.contains(voisin)){
                    if(!ouvert.contains(voisin)){
                        ouvert.add(voisin);
                    }
                }
            }
        }
    }




    public Boolean estBut(Etat etat){ return true; }
    // Fonction pour récupérer le meilleur état dans l'ensemble Ouvert
    /*public static State meilleur(PriorityQueue<State> ouvert) {
        return ouvert.peek();
        }*/

}