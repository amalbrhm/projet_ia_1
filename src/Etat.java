import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Etat {
        private String name;
        private List<Integer> contenus;
        private int heuristic;
        int [] seaux;

        public Etat(String name,List<Integer> contenu, int heuristic) {
            this.name = name;
            this.contenus = contenu;
            this.heuristic = heuristic;

        }

    public Etat(int[] seaux) {
        this.seaux=Arrays.copyOf(seaux,seaux.length);
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

    @Override
    public String toString() {
        return "Etat{name='" + name + "', contenus=" + contenus + ", heuristic=" + heuristic + "}";

    }

    // pour remplir le seau jusqu'à ce qu'il soit plein
    public Etat replissageSeau(int index,int capacityMax){
            if(seaux[index]<capacityMax){
                int [] newSeaux = Arrays.copyOf(seaux,seaux.length);
                newSeaux[index]=capacityMax;
                return new Etat(newSeaux);
            }
            return null;
    }

    //vider complétement un seau
    public Etat viderSeau(int index){
        if (seaux[index]>0){
            int [] newSeaux= Arrays.copyOf(seaux,seaux.length);
            newSeaux[index]=0;
            return new Etat(newSeaux);
        }
        return null;
    }

    //transvaser le contenu d'un seau vers un autre
    public Etat transvaserEau(int seauA,int seauB,int capacityMax){
            if (seaux[seauA]>0 && seaux[seauB]<0){
                int [] newSeaux=Arrays.copyOf(seaux,seaux.length);
                int transvaser=Math.min(seaux[seauA],capacityMax-seaux[seauB]);
                newSeaux[seauA]-=transvaser;
                newSeaux[seauB]+=transvaser;
                return new Etat(newSeaux);
            }
            return null;
    }

}
