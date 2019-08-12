import egzaminas.Egzaminas;
import studentai.StudIvertinimas;

import java.util.ArrayList;

public class PatikrintiEgzaminai {
    private Egzaminas egzaminas;
    private ArrayList<StudIvertinimas> studIvertinimasArrayList;

    PatikrintiEgzaminai() {

    }

    PatikrintiEgzaminai(Egzaminas egzaminas, ArrayList<StudIvertinimas> studIvertinimasArrayList) {
        this.egzaminas = egzaminas;
        this.studIvertinimasArrayList = studIvertinimasArrayList;

    }

    public Egzaminas getEgzaminas() {
        return egzaminas;
    }

    public void setEgzaminas(Egzaminas egzaminas) {
        this.egzaminas = egzaminas;
    }

    public ArrayList<StudIvertinimas> getStudIvertinimasArrayList() {
        return studIvertinimasArrayList;
    }

    public void setStudIvertinimasArrayList(ArrayList<StudIvertinimas> studIvertinimasArrayList) {
        this.studIvertinimasArrayList = studIvertinimasArrayList;
    }
}
