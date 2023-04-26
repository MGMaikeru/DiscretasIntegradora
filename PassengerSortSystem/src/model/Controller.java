package model;

import exception.EmptyFieldException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static java.lang.Integer.parseInt;

public class Controller {
    private HashMap<Passenger, String> table;
    private Heap<Passenger> entryOrder;
    private Stack<Passenger> exitOrder;

    public Controller(){
        table = new HashMap<>(100);
        entryOrder = new Heap<>();
        exitOrder = new Stack<>();
    }

    public String confirmAssistance(String id){
        Passenger passenger = table.hashSearch(id);
        if (passenger == null){
            return "Passenger ID hasn't been find.";
        }
        passenger.confirmAssistance();
        passenger.setConfirmationHour(getActuallyDate());
        addToEntryList(passenger);
        return passenger + "\nPassenger has been confirmed assistance.\n";
    }

    public void addToEntryList(Passenger passenger){
        entryOrder.maxHeapInsert(passenger);
    }

    public String generateEntryList(){
        String list = entryOrder.printArray();

        if (!list.equals("")){
            return list;
        }
        return "There aren´t confirmed passengers yet";
    }

    public String addToExistList(){
        int size = 0;
        String list = "";
        for (int i = 0; i < entryOrder.getArray().size(); i++){
            exitOrder.push(new StackNode<>( entryOrder.getArray().get(i)) );
            size++;
        }

        if (size == 0){
            return "There aren´t confirmed passengers!";
        }

        try {
            for (int i = 0; i < size; i++){
                list += i + ") " + exitOrder.pop().toString() + "\n";
            }
        }catch (EmptyFieldException e){

        }
        return list;
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

    public String getActuallyDate() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR);
        int minutes = calendar.get(Calendar.MINUTE);
        int seconds = calendar.get(Calendar.SECOND);
        return hour + ":" + minutes + ":"+seconds;
    }

    private int calculatePriority(int age, String handicapped, String pregnancy, String section){
        int priority = 0;
        if (age<110 || age>12){

            if (section.equals("FirstClass")){
                priority += 60;
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
