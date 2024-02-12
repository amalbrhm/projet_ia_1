import java.util.ArrayList;
import java.util.List;

public class Etat {
        private String name;
        private List<Integer> contenus;
        private int heuristic;

        public Etat(String name,List<Integer> contenu, int heuristic) {
            this.name = name;
            this.contenus = contenu;
            this.heuristic = heuristic;
        }

        public String getName() {
            return name;
        }

        public int getHeuristic() {
            return heuristic;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setHeuristic(int heuristic) {
            this.heuristic = heuristic;
        }

    public List<Integer> getContenus() {
        return contenus;
    }

    public void setContenus(List<Integer> contenu) {
        this.contenus = contenu;
    }

    public boolean estBut() {
            return false;
        }
        public List<Etat> getVoisins() {
            return new ArrayList<>();
        }

}
