package egzaminas;

public class Egzaminas {

    private int egzaminoId;
    private String egzaminoPavadinimas;

    Egzaminas() {

    }

    Egzaminas(int egzaminoId, String egzaminoPavadinimas) {
        this.egzaminoId = egzaminoId;
        this.egzaminoPavadinimas = egzaminoPavadinimas;
    }

    public int getEgzaminoId() {
        return egzaminoId;
    }

    public void setEgzaminoId(int egzaminoId) {
        egzaminoId = egzaminoId;
    }

    public String getEgzaminoPavadinimas() {
        return egzaminoPavadinimas;
    }

    public void setEgzaminoPavadinimas(String egzaminoPavadinimas) {
        this.egzaminoPavadinimas = egzaminoPavadinimas;
    }
}
