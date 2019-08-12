import egzaminas.Egzaminas;
import egzaminas.KlausimoAtsakymai;
import studentai.Studentas;

import java.io.Serializable;
import java.util.HashMap;

public class DoneEgzaminasIJSON implements Serializable {
    private Egzaminas egzaminas;
    private Studentas studentas;
    private HashMap<Integer, KlausimoAtsakymai> hashMapAtsakymai;

    DoneEgzaminasIJSON() {

    }

    DoneEgzaminasIJSON(Egzaminas egzaminas, Studentas studentas, HashMap<Integer, KlausimoAtsakymai> hashMapAtsakymai) {
        this.egzaminas = egzaminas;
        this.studentas = studentas;
        this.hashMapAtsakymai = hashMapAtsakymai;

    }

    public Egzaminas getEgzaminas() {
        return egzaminas;
    }

    public void setEgzaminas(Egzaminas egzaminas) {
        this.egzaminas = egzaminas;
    }

    public Studentas getStudentas() {
        return studentas;
    }

    public void setStudentas(Studentas studentas) {
        this.studentas = studentas;
    }

    public HashMap<Integer, KlausimoAtsakymai> getHashMapAtsakymai() {
        return hashMapAtsakymai;
    }

    public void setHashMapAtsakymai(HashMap<Integer, KlausimoAtsakymai> hashMapAtsakymai) {
        this.hashMapAtsakymai = hashMapAtsakymai;
    }
}
