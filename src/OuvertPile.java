import java.util.List;
import java.util.Stack;

public class OuvertPile implements Ouvert{
    private List ouvert;
    @Override
    public void structure() {
        ouvert = new Stack<List>();
    }

    @Override
    public void ajout(List liste) {
        ouvert.add(liste);
    }

    @Override
    public Boolean estVide() {
        return ouvert.isEmpty();
    }

    @Override
    public List teteOuvert() {
        return null;
    }

    @Override
    public List<Integer> supprimerEtat(Ouvert ouvert) {
        return this.ouvert.remove();
    }
}
