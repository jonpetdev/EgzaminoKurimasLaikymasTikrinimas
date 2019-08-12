package egzaminas;

public class EgzaminoKlausimai {

    private int klausimoNumeris;
    private String klausimasIrAtsakymuVaiantai;
    private KlausimoAtsakymai klausimoTeisingasAtsakymas;

    EgzaminoKlausimai() {

    }

    EgzaminoKlausimai(int klausimoNumeris, String klausimasIrAtsakymuVaiantai, KlausimoAtsakymai klausimoTeisingasAtsakymas) {
        this.klausimoNumeris = klausimoNumeris;
        this.klausimasIrAtsakymuVaiantai = klausimasIrAtsakymuVaiantai;
        this.klausimoTeisingasAtsakymas = klausimoTeisingasAtsakymas;

    }

    public int getKlausimoNumeris() {
        return klausimoNumeris;
    }

    public void setKlausimoNumeris(int klausimoNumeris) {
        this.klausimoNumeris = klausimoNumeris;
    }

    public String getKlausimasIrAtsakymuVaiantai() {
        return klausimasIrAtsakymuVaiantai;
    }

    public void setKlausimasIrAtsakymuVaiantai(String klausimasIrAtsakymuVaiantai) {
        this.klausimasIrAtsakymuVaiantai = klausimasIrAtsakymuVaiantai;
    }

    public KlausimoAtsakymai getKlausimoTeisingasAtsakymas() {
        return klausimoTeisingasAtsakymas;
    }

    public void setKlausimoTeisingasAtsakymas(KlausimoAtsakymai klausimoTeisingasAtsakymas) {
        this.klausimoTeisingasAtsakymas = klausimoTeisingasAtsakymas;
    }


}
