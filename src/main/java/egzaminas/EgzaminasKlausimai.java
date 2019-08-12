package egzaminas;

import java.util.ArrayList;

public class EgzaminasKlausimai {
    private Egzaminas egzaminas;
    private ArrayList<EgzaminoKlausimai> egzaminoKlausimaiArrayList;

    EgzaminasKlausimai() {

    }

    public EgzaminasKlausimai(Egzaminas egzaminas, ArrayList<EgzaminoKlausimai> egzaminoKlausimaiArrayList) {
        this.egzaminas = egzaminas;
        this.egzaminoKlausimaiArrayList = egzaminoKlausimaiArrayList;
    }

    public Egzaminas getEgzaminas() {
        return egzaminas;
    }

    public void setEgzaminas(Egzaminas egzaminas) {
        this.egzaminas = egzaminas;
    }

    public ArrayList<EgzaminoKlausimai> getEgzaminoKlausimaiArrayList() {
        return egzaminoKlausimaiArrayList;
    }

    public void setEgzaminoKlausimaiArrayList(ArrayList<EgzaminoKlausimai> egzaminoKlausimaiArrayList) {
        this.egzaminoKlausimaiArrayList = egzaminoKlausimaiArrayList;
    }
}
