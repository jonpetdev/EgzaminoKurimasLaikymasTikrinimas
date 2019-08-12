package egzaminas;

import java.util.ArrayList;
import java.util.Scanner;

public class EgzaminoSukurimas {
    ArrayList<EgzaminoKlausimai> egzaminoKlausimaiArrayList = new ArrayList<>();

    public EgzaminasKlausimai egzaminasKlausimai;


    public void klausimuIvedimas() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Sukurkite Egzamino ID");
        int egzaminoId = sc.nextInt();
        System.out.println("Sukurkite Egzamino pavadinima:");
        sc.nextLine();
        String egzaminoPavadinimas = sc.nextLine();
        Egzaminas egz = new Egzaminas(egzaminoId, egzaminoPavadinimas);

        int klausymoNumeris = 0;
        String klausimasIrAtsakymoVariantai;
        KlausimoAtsakymai klausimoTesingasAtsakymas;
        String busena = "";

        while (!busena.equals("EXIT")) {
            klausymoNumeris++;
            System.out.println("Klausimo numeris:" + klausymoNumeris);
            System.out.println("Iveskite klausyma ir jo 4 Atsakymo variantus");
            klausimasIrAtsakymoVariantai = sc.nextLine();
            System.out.println("Pasirinkite teisinga varianta");
            System.out.println("A,B,C,D");
            String teisingi = sc.nextLine();
            switch (teisingi) {
                case "A":
                    klausimoTesingasAtsakymas = KlausimoAtsakymai.A;
                    break;
                case "B":
                    klausimoTesingasAtsakymas = KlausimoAtsakymai.B;
                    break;
                case "C":
                    klausimoTesingasAtsakymas = KlausimoAtsakymai.C;
                    break;
                case "D":
                    klausimoTesingasAtsakymas = KlausimoAtsakymai.D;
                    break;
                default:
                    System.out.println("Nera tokio pasirinkimo");
                    continue;
            }

            egzaminoKlausimaiArrayList.add(new EgzaminoKlausimai(klausymoNumeris, klausimasIrAtsakymoVariantai, klausimoTesingasAtsakymas));
            System.out.println("Ivesti dar klausima- paspaskite ENTER \nBaigti egzamino sudaryma - iveskite EXIT ");
            busena = sc.nextLine();

        }


        egzaminasKlausimai = new EgzaminasKlausimai(egz, egzaminoKlausimaiArrayList);
    }

}
