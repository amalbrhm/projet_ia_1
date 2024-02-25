public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");
            String cheminFichier = "src/instances/3_7_13_19_23_29_a.buck";


            RechercheEnProfondeur recherche = new RechercheEnProfondeur(cheminFichier);
            recherche.heuristic();
            System.out.println("Ferme: " + recherche.ferme);
            System.out.println("Ouvert: " + recherche.ouvert);
    }






}