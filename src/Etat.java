import java.util.ArrayList;
import java.util.List;

public class Etat {
        private String name;
        private int contenu;
        private int heuristic;

        public Etat(String name,int contenu, int heuristic) {
            this.name = name;
            this.contenu = contenu;
            this.heuristic = heuristic;
        }

        public String getName() {
            return name;
        }

        public int getContenu() {
            return contenu;
        }

        public void setContenu(int contenu) {
            this.contenu = contenu;
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

        public boolean estBut() {
            return false;
        }

        public List<Etat> getVoisins() {
            return new ArrayList<>();
        }
}
