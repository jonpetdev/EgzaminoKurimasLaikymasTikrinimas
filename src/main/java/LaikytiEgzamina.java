import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import egzaminas.*;
import studentai.AddStudentToFile;
import studentai.GetStudentasFromFile;
import studentai.Studentas;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;


public class LaikytiEgzamina extends AddStudentToFile implements Serializable {
    int id;
    String vardas;
    String pavarde;
    String egzaminoPavadinimas;
    Studentas studentasas;

    LaikytiEgzamina() {

    }

    public void laikom() throws IOException {

        Scanner sc = new Scanner(System.in);
        GetStudentasFromFile getst = new GetStudentasFromFile();

        System.out.println("Irasykite Egzamina laikancio studento ID:");
        boolean kazkasID = true;
        while (kazkasID == true) {
            id = sc.nextInt();

            for (Studentas val : getst.gautiDuomenis()) {
                if (id == val.getId()) {
                    vardas = val.getVardas();
                    pavarde = val.getPavarde();
                    studentasas = val;
                    kazkasID = false;
                }
            }
            if (kazkasID == true) {
                System.out.println("nera tokio studento.Bandykite dar karta:");
            }
        }

        System.out.println("Laba diena:" + vardas + " " + pavarde);
        System.out.println("-".repeat(20));
        List<String> results = new ArrayList<>();
        File[] files = new File("target/Egzaminai/").listFiles();
        for (File file : files) {
            if (file.isFile()) {
                results.add(file.getName());
            }
        }
        results.stream().forEach(System.out::println);
        System.out.println("-".repeat(20));
        System.out.println("Irasykite egzamino pavadinima kuri laikysite:");
        sc.nextLine();
        boolean kazkasEG = true;
        while (kazkasEG == true) {

            egzaminoPavadinimas = sc.nextLine();

            for (String egz : results) {
                if (egzaminoPavadinimas.equals(egz.replaceAll("(\\.json)", ""))) {
                    kazkasEG = false;
                }
            }
            if (kazkasEG == true) {
                System.out.println("nera tokio egzamino.Bandykite dar karta:");
            }
        }

        List<String> resultas = new ArrayList<>();
        File[] filas = new File("target/StudentuLaikyti/").listFiles();
        for (File fil : filas) {
            if (fil.isFile()) {
                resultas.add(fil.getName());
            }
        }


        EgzaminoGavimas egzaminoGavimas = new EgzaminoGavimas();
        EgzaminasKlausimai egkl = egzaminoGavimas.gautiEgza(egzaminoPavadinimas);
        boolean arJauLaike = false;
        ObjectMapper mapper = new ObjectMapper();
        DoneEgzaminasIJSON obj3 = null;

        for (int i = 0; i < resultas.size(); i++) {

            obj3 = mapper.readValue(new File("target/StudentuLaikyti/" + resultas.get(i)), DoneEgzaminasIJSON.class);

            if (egkl.getEgzaminas().getEgzaminoPavadinimas().equals(obj3.getEgzaminas().getEgzaminoPavadinimas())) {

                if (studentasas.getId() == obj3.getStudentas().getId()) {
                    System.out.println("Studentas jau laike si egzamina");
                    arJauLaike = true;

                } else {

                }


            }


        }
        if (arJauLaike == false) {

            LaikasEgzui laikasEgzui=new LaikasEgzui();


                Thread threadLaikas = new Thread(laikasEgzui);
                threadLaikas.start();


                System.out.println("-".repeat(20));
                System.out.println("Sekmes laikant egzamina!.......");
                System.out.println("-".repeat(20));
                HashMap<Integer, KlausimoAtsakymai> atsakymuHashMap = new HashMap<>();
            boolean laikas;

                for (EgzaminoKlausimai egzklausimai : egkl.getEgzaminoKlausimaiArrayList()) {
                    System.out.println(egzklausimai.getKlausimoNumeris() + ". " + egzklausimai.getKlausimasIrAtsakymuVaiantai());
                    boolean kazkasATS = true;
                    while (kazkasATS == true) {

                        laikas=laikasEgzui.done;
                        if(laikas==false) break;


                        String ats = sc.nextLine();
                        switch (ats) {
                            case "A":
                                atsakymuHashMap.put(egzklausimai.getKlausimoNumeris(), KlausimoAtsakymai.A);
                                kazkasATS = false;
                                break;
                            case "B":
                                atsakymuHashMap.put(egzklausimai.getKlausimoNumeris(), KlausimoAtsakymai.B);
                                kazkasATS = false;
                                break;
                            case "C":
                                atsakymuHashMap.put(egzklausimai.getKlausimoNumeris(), KlausimoAtsakymai.C);
                                kazkasATS = false;
                                break;
                            case "D":
                                atsakymuHashMap.put(egzklausimai.getKlausimoNumeris(), KlausimoAtsakymai.D);
                                kazkasATS = false;
                                break;
                            default:
                                System.out.println("nera tokio pasirinkimo");

                        }


                    }

                }
            threadLaikas.stop();

            System.out.println("-".repeat(20));
            System.out.println("Egzaminas baigtas");

            ObjectMapper mapperIrasyti = new ObjectMapper();
            mapperIrasyti.enable(SerializationFeature.INDENT_OUTPUT);
            File file = new File("target/StudentuLaikyti/" + vardas + pavarde + egkl.getEgzaminas().getEgzaminoPavadinimas() + ".json");
            try {
                mapperIrasyti.writeValue(file, new DoneEgzaminasIJSON(egkl.getEgzaminas(), studentasas, atsakymuHashMap));
                System.out.println("egzamino fialas sukurtas!....");


            } catch (IOException e) {
                e.printStackTrace();
            }
                Tikrinti tikrinti = new Tikrinti();
                tikrinti.patikrinimas();
        }


    }

}
