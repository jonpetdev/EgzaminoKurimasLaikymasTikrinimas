package studentai;

public class StudIvertinimas extends Studentas {

    private int ivertinimas;

    StudIvertinimas() {
    }

    public StudIvertinimas(int id, String vardas, String pavarde, int ivertinimas) {
        super(id, vardas, pavarde);
        this.ivertinimas = ivertinimas;
    }

    public int getIvertinimas() {
        return ivertinimas;
    }

    public void setIvertinimas(int ivertinimas) {
        this.ivertinimas = ivertinimas;
    }
}

