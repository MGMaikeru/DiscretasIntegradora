package model;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class Controller {

    public Controller(){

    }

    public String importDataFromCSV(){
        try {
            File projectDir = new File(System.getProperty("user.dir"));
            File dataDirectory = new File(projectDir.getName()+"/data");
            File result = new File(projectDir+"/data/data.csv");
            FileInputStream fis = new FileInputStream(result);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

            CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT.withDelimiter('|'));

            ArrayList<Passenger> temporalList = new ArrayList<>();

            for (CSVRecord o: parser) {
                if (o.getRecordNumber() != 1){
                    int priority = calculatePriority(parseInt(o.get(2)), o.get(3), o.get(4));
                    calculatePriority(parseInt(o.get(2)), o.get(3), o.get(4));
                    Passenger newPassenger = new Passenger(o.get(0), o.get(1), parseInt(o.get(2)), priority);
                    temporalList.add(newPassenger);
                    System.out.println("Name: " + newPassenger.getName() + "\n" + "ID: " + newPassenger.getId() + "\n" + "Age: " + newPassenger.getAge() + "\n" + "Priority: " + newPassenger.getPriority() + "\n");
                }
            }

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return "Succesful import!";
    }

    private int calculatePriority(int age, String handicapped, String pregnancy){
        int priority = 0;
        if (age<110 || age>12){
            if (age > 60) {
                priority += 5;
            }
            if (handicapped.equals("x")) {
                priority += 3;
            }
            if (pregnancy.equals("x")) {
                priority += 2;
            }
        }
        return priority;
    }
}
