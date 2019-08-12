package egzaminas;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class EgzaminoGavimas {


    public EgzaminasKlausimai gautiEgza(String egzoPavadinimas) {
        ObjectMapper mapper = new ObjectMapper();
        EgzaminasKlausimai obj;

        try {
            obj = mapper.readValue(new File("target/Egzaminai/" + egzoPavadinimas + ".json"), EgzaminasKlausimai.class);
            return obj;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
