import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import egzaminas.EgzaminasKlausimai;
import studentai.StudIvertinimas;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Tikrinti implements Serializable {


    Tikrinti() {

    }

    public void patikrinimas() throws IOException {
        List<String> resultsStudLaikyti = new ArrayList<>();
        File[] filesLAIK = new File("target/StudentuLaikyti/").listFiles();
        for (File file : filesLAIK) {
            if (file.isFile()) {
                resultsStudLaikyti.add(file.getName());
            }
        }
        List<String> resultsEgzaminai = new ArrayList<>();
        File[] filesEGZ = new File("target/Egzaminai/").listFiles();
        for (File file : filesEGZ) {
            if (file.isFile()) {
                resultsEgzaminai.add(file.getName());
            }
        }

        EgzaminasKlausimai obj = null;
        DoneEgzaminasIJSON obj2=null;
        ArrayList<StudIvertinimas> ka = new ArrayList<>();

        for (int i = 0; i < resultsEgzaminai.size(); i++) {
            ObjectMapper mapper = new ObjectMapper();
            //EgzaminasKlausimai obj;
            obj = mapper.readValue(new File("target/Egzaminai/" + resultsEgzaminai.get(i)), EgzaminasKlausimai.class);
            for(int a = 0; a < resultsStudLaikyti.size(); a++) {
                //DoneEgzaminasIJSON obj2;
                obj2 = mapper.readValue(new File("target/StudentuLaikyti/" + resultsStudLaikyti.get(a)), DoneEgzaminasIJSON.class);
                if (obj.getEgzaminas().getEgzaminoPavadinimas().equals(obj2.getEgzaminas().getEgzaminoPavadinimas())) {


                    int teisingas = 0;
                    for (int b = 0; b < obj.getEgzaminoKlausimaiArrayList().size(); b++) {

                        if (obj.getEgzaminoKlausimaiArrayList().get(b).getKlausimoTeisingasAtsakymas() == obj2.getHashMapAtsakymai().get(b + 1)) {
                            teisingas++;

                        } else {

                        }

                    }
                    int ivertinimas = (teisingas * 10) / obj.getEgzaminoKlausimaiArrayList().size();
                    ka.add(new StudIvertinimas(obj2.getStudentas().getId(), obj2.getStudentas().getVardas(), obj2.getStudentas().getPavarde(), ivertinimas));

                }


            }


            PatikrintiEgzaminai patikrintiEgzaminai = new PatikrintiEgzaminai(obj.getEgzaminas(), ka);

            String egzaminoKlausimuFailoPavadinimas = obj.getEgzaminas().getEgzaminoPavadinimas();
            ObjectMapper mapperIrasyti = new ObjectMapper();
            mapperIrasyti.enable(SerializationFeature.INDENT_OUTPUT);
            File file = new File("target/Rezultatai/" + egzaminoKlausimuFailoPavadinimas + ".json");
            try {
                mapperIrasyti.writeValue(file, patikrintiEgzaminai);
                System.out.println(egzaminoKlausimuFailoPavadinimas + " fialas sukurtas!....");
            } catch (IOException e) {
                e.printStackTrace();
            }
            ka.clear();


        }

    }

}
