import java.util.*;

public class RechercheEnProfondeur {
    List<Etat> ferme = new ArrayList<>();
    Stack<Etat> ouvert = new Stack<>() ;
    Etat etatFinal;
    List<Integer> quantitesMax ;
    public RechercheEnProfondeur(){
        etatFinal = new Etat("final",new ArrayList<>(Arrays.asList(0,0,0,10)),0);
        quantitesMax = new ArrayList<>(Arrays.asList(2,3,5,10));
    }
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
    public Boolean estBut(Etat etat){
        return etat.getContenus() == etatFinal;
    }
    public void remplirT(Etat etat,int i){
        etat.getContenus().set(i,quantitesMax.get(i));
    }
    public void viderT(Etat etat,int i){
        etat.getContenus().set(i,0);
    }
    public void transvaserD(Etat etat,int g,int d){
        etat.getContenus().set(g,(quantitesMax.get(d)-etat.getContenus().get(d)));
        etat.getContenus().set(d,(quantitesMax.get(d)-etat.getContenus().get(d)));
    }
    public void transvaserG(Etat etat,int g,int d){
        etat.getContenus().set(g,(quantitesMax.get(g)-etat.getContenus().get(g)));
        etat.getContenus().set(d,(quantitesMax.get(g)-etat.getContenus().get(g)));
    }


}