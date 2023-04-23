package model;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.awt.event.ComponentAdapter;
import java.io.*;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class Controller {
    private HashMap<Passenger, String> table;
    private Heap<Passenger> entryOrder;

    public Controller(){
        table = new HashMap<>(100);
        entryOrder = new Heap<>();
    }

    public String confirmAssistance(String id){
        Passenger passenger = table.hashSearch(id);
        if (passenger == null){
            return "Passenger ID hasn't been find.";
        }
        passenger.confirmAssistance();
        addToEntryList(passenger);
        return passenger.toString() + "\nPassenger has been confirmed assistance.\n";
    }

    public void addToEntryList(Passenger passenger){
        entryOrder.maxHeapInsert(passenger);
    }

    public String generateEntryList(){
        String list = "";
        list = entryOrder.printArray();

        if (!list.equals("")){
            return list;
        }
        return "There aren´t confirmed passengers yet";
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
                    int priority = calculatePriority(parseInt(o.get(2)), o.get(3), o.get(4), o.get(5));
                    Passenger newPassenger = new Passenger(o.get(0), o.get(1), parseInt(o.get(2)), o.get(5),priority);
                    table.hashInsert(newPassenger, newPassenger.getId());
                    System.out.println("Name: " + newPassenger.getName() + "\n" + "ID: " + newPassenger.getId() + "\n" + "Age: " + newPassenger.getAge() + "\n" + "Priority: " + newPassenger.getPriority() + "\n");
                }
            }

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return "Successful import!";
    }

    private int calculatePriority(int age, String handicapped, String pregnancy, String section){
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
            if (section.equals("FirstClass")){
                priority += 60;
            }
            if (section.equals("BusinessClass")){
                priority += 40;
            }
            if (section.equals("TouristClass")){
                priority += 20;
            }
        }
        return priority;
    }
}
