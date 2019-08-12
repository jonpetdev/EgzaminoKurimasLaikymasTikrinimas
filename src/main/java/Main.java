import egzaminas.EgzaminoKlausimaiJSON;
import egzaminas.EgzaminoSukurimas;
import studentai.AddStudentToFile;
import studentai.GetStudentasFromFile;
import studentai.Studentas;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String [] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean programosStatusas =true;
        while(programosStatusas==true){
            meniu();
            System.out.println("Pasirinite:");

            int meniuPasirinkimas= sc.nextInt();
            switch (meniuPasirinkimas){
                case 1:
                    sukurtiEgzamina();
                    break;
                case 2:
                    pridetiStudenta();
                    break;
                case 3:
                    laikytiEgzamina();
                    break;
                case 4:
                    System.out.println("-".repeat(30));
                    System.out.println("Programa baige darba!!!");
                    System.out.println("-".repeat(30));
                    programosStatusas=false;
                    break;
//                case 5:
//                    tikrintiEgzamina();
//                    break;
                    default:
                        System.out.println("Nera tokio pasirinkimo");
            }

        }




    }

    public static void meniu(){
        System.out.println("-".repeat(30));
        System.out.println("[1]- Sukurti Egzamina -[1]\n" +
                "[2]- Prideti studenta -[2]\n" +
                "[3]- Laikyti egzamina -[3]\n" +
                "[4]- Baigti programa -[4]");
        System.out.println("-".repeat(30));
    }

    public static void sukurtiEgzamina() {
        EgzaminoSukurimas egzaminoSukurimas = new EgzaminoSukurimas();
        EgzaminoKlausimaiJSON egzaminoKlausimaiJSON = new EgzaminoKlausimaiJSON();
        egzaminoSukurimas.klausimuIvedimas();
        egzaminoKlausimaiJSON.irasytiEgzaminaIFaila(egzaminoSukurimas.egzaminasKlausimai);
    }

    public static void pridetiStudenta() throws IOException {
        GetStudentasFromFile getstudents = new GetStudentasFromFile();
        ArrayList<Studentas> studentasList = getstudents.gautiDuomenis();
        AddStudentToFile addStudentToFile = new AddStudentToFile();
        addStudentToFile.addStudenta(studentasList);
        addStudentToFile.writeToStudentFile();
    }

    public static void laikytiEgzamina() throws IOException {
        LaikytiEgzamina laikyti = new LaikytiEgzamina();
        laikyti.laikom();
    }

    public static void tikrintiEgzamina() throws IOException {
        Tikrinti tikrinti = new Tikrinti();
        tikrinti.patikrinimas();
    }


}
