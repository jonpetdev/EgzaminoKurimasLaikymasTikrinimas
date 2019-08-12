package studentai;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GetStudentasFromFile {


    public ArrayList<Studentas> gautiDuomenis() {

        ArrayList<Studentas> list = new ArrayList<>();

        String line = "";
        BufferedReader buferis = null;
        try {
            buferis = new BufferedReader(new FileReader("target/studentai.csv"));
            while ((line = buferis.readLine()) != null) {
                String[] gauta = line.split(",");
                int id = Integer.parseInt(gauta[0]);
                String vardas = gauta[1];
                String pavarde = gauta[2];
                list.add(new Studentas(id, vardas, pavarde));

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return list;


    }

}
