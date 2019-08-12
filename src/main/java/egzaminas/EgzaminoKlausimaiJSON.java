package egzaminas;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

public class EgzaminoKlausimaiJSON extends EgzaminoSukurimas implements Serializable {


    public void irasytiEgzaminaIFaila(EgzaminasKlausimai egzaminasKlausimai) {


        Scanner sc = new Scanner(System.in);
        String egzaminoKlausimuFailoPavadinimas;
        System.out.println("Parasykite egzamino Failo pavadinima");
        egzaminoKlausimuFailoPavadinimas = sc.nextLine();
        ObjectMapper mapperIrasyti = new ObjectMapper();
        mapperIrasyti.enable(SerializationFeature.INDENT_OUTPUT);
        File file = new File("target/Egzaminai/" + egzaminoKlausimuFailoPavadinimas + ".json");
        try {
            mapperIrasyti.writeValue(file, egzaminasKlausimai);
            System.out.println("egzamino fialas sukurtas!....");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




}
