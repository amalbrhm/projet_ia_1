import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class RechercheEnProfondeur {
    List<Etat> ferme = new ArrayList<>();
    Stack<Etat> ouvert = new Stack<>() ;
    private List<Integer> volumeFinal;

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
    public Etat etatInitial(int nbrSeaux,List<Integer> contenanceMax, List<Integer> volumes){
        if(nbrSeaux==contenanceMax.size() && nbrSeaux==volumes.size()){
            int []volumeInitial = new int[nbrSeaux];
            for (int i=0; i< nbrSeaux;i++){
                volumeInitial[i]= volumes.get(i);
            }
            return new Etat("initial",Arrays.stream(volumeInitial).boxed().collect(Collectors.toList()),0);
        }else{
            throw new IllegalArgumentException("error");
        }
    }
    public RechercheEnProfondeur(String cheminFichier){

        try{
            BufferedReader lecteure = new BufferedReader(new FileReader(cheminFichier));
            //lire le nbr de seaux
            int nbrSeaux = Integer.parseInt(lecteure.readLine());
            //lire le contenu max du seau

            List<Integer> contenancesMax = Arrays.stream(lecteure.readLine().split("\\s+"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());


            // le volume d'eau dans le seau à létat final
            volumeFinal =  Arrays.stream(lecteure.readLine().split("\\s+"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            Etat etatInitial= etatInitial(nbrSeaux,contenancesMax,volumeFinal);


            System.out.println(nbrSeaux);
            System.out.println(contenancesMax);
            System.out.println(volumeFinal);

        }catch(IOException e){
            e.printStackTrace();
        }


    }

    public Boolean estBut(Etat etat){
        List<Integer> contenanceActuel= etat.getContenus();
        return contenanceActuel.equals(volumeFinal);
    }


}