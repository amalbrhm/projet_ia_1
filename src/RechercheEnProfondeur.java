import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.*;
import java.util.stream.Collectors;

public class RechercheEnProfondeur {
    List<Etat> ferme = new ArrayList<>();
    Stack<Etat> ouvert = new Stack<>() ;

    public void heuristic() {
        Etat etat;
        //Initialisation de ferme
        ferme = new ArrayList<>();
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

    public static void main (String[]args) throws IOException {
        String cheminFichier = "instances/3_7_13_19_23_29_a.buck";

        try{BufferedReader lecteure = new BufferedReader(new FileReader(cheminFichier)) ;
                //lire le nbr de seaux

                int nbrSeaux = Integer.parseInt(lecteure.readLine());
                //lire le contenu max du seau

                List<Integer> contenancesMax = Arrays.stream(lecteure.readLine().split("\\s+"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());


                // le volume d'eau dans le seau à létat final
                List<Integer> volumes =  Arrays.stream(lecteure.readLine().split("\\s+"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Boolean estBut(Etat etat){
        return true;
    }
    // Fonction pour récupérer le meilleur état dans l'ensemble Ouvert
    /*public static State meilleur(PriorityQueue<State> ouvert) {
        return ouvert.peek();
        }*/

}