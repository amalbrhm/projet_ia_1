import java.util.List;
import java.util.Stack;

public class OuvertPile implements Ouvert{
    private List<Integer> ouvert;
    @Override
    public void structure() {
        ouvert = new Stack<>();
    }


    @Override
    public void ajout(List<Integer> liste) {
        ouvert.push(liste);
    }

    @Override
    public Boolean estVide() {
        return ouvert.isEmpty();
    }

    @Override
    public List<Integer> teteOuvert() {
        if (!ouvert.isEmpty()){
            return ouvert.peek();
        }
        return null;
    }



    public List<Integer> supprimerEtat(List<Integer> contenu) {
        ouvert.remove(contenu);
        return contenu;
    }
}
