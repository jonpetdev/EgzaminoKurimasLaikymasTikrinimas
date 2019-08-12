package studentai;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class AddStudentToFile {

    int id;
    String vardas;
    String pavarde;
    ArrayList<Studentas> studentuListas = new ArrayList<>();

    public void addStudenta(ArrayList<Studentas> stud) {
        studentuListas.addAll(stud);
        List<Studentas> studentasList;
        studentasList=studentuListas.stream().distinct().collect(Collectors.toList());


        System.out.println("-".repeat(30));
        for(int i=0;i<studentasList.size();i++){
            System.out.println(studentasList.get(i).getId()+" "+studentasList.get(i).getVardas()+" "+studentasList.get(i).getPavarde());
        }
        System.out.println("-".repeat(30));

        Scanner sc = new Scanner(System.in);
        System.out.println("Iveskite studento ID:");
        id = sc.nextInt();
        System.out.println("Iveskite studento varda:");
        sc.nextLine();
        vardas = sc.nextLine();
        System.out.println("Iveskite studento pavarde:");
        pavarde = sc.nextLine();

        studentuListas.add(new Studentas(id, vardas, pavarde));

    }

    public void writeToStudentFile() throws IOException {
        File file = new File("target/studentai.csv");
        String studentuDuomenys = "";
        FileWriter writer = new FileWriter(file);

        for (int i = 0; i < studentuListas.size(); i++) {


            studentuDuomenys = studentuDuomenys + "" + studentuListas.get(i).getId() + "," + studentuListas.get(i).getVardas() + "," + studentuListas.get(i).getPavarde() + "\n";
        }

        writer.write(studentuDuomenys);
        writer.flush();

    }
}
