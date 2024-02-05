import java.util.List;

public interface Ouvert {
    // retourner la structure appropriée à ouvert
     void structure(); // return new (pile) (file) (liste triee)
     void ajout(List liste);
     Boolean estVide();
     List teteOuvert();
     List supprimerEtat(List<Integer> contenu);
}
