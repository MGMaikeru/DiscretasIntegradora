package model;

import exception.EmptyFieldException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

import static java.lang.Integer.parseInt;

public class Controller {
    private HashMap<Passenger, String> table;
    private Heap<Passenger> entryOrder;
    private Stack<Passenger> exitOrder;

    private boolean isLoaded;

    public Controller(){
        table = new HashMap<>(100);
        entryOrder = new Heap<>();
        exitOrder = new Stack<>();
        isLoaded = false;
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
        String list = "";
        int position = 1;
        entryOrder.heapSort();
        for (int i = entryOrder.getArray().size()-1; i >= 0; i--){
            list += (position++) + ") " +entryOrder.getArray().get(i).toString() + "\n";
        }

        if (!list.equals("")){
            return list;
        }
        return "There aren´t confirmed passengers yet";
    }

    public String addToExistList(){
        int size = 0;
        String list = "";
        ArrayList<Passenger> confirmedPassengers = new ArrayList<>(entryOrder.getArray());

        if (confirmedPassengers.size() == 0){
            return "There aren´t confirmed passengers!";
        }

        Collections.sort(confirmedPassengers, new CompareChairNumber());

        for (Passenger confirmedPassenger : confirmedPassengers) {
            exitOrder.push(new StackNode<>(confirmedPassenger));
            size++;
        }

        try {
            for (int i = 0; i < size; i++){
                list += i + 1 + ") " + exitOrder.pop().toString() + "\n";
            }
        }catch (EmptyFieldException e){

        }
        return list;
    }

    public String importDataFromCSV(){
        if (isLoaded){
            return "The data base has already loaded!";
        }
        try {
            File projectDir = new File(System.getProperty("user.dir"));
            File result = new File(projectDir+"/data/data.csv");
            FileInputStream fis = new FileInputStream(result);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

            CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT.withDelimiter('|'));

            ArrayList<Passenger> temporalList = new ArrayList<>();

            for (CSVRecord o: parser) {
                if (o.getRecordNumber() != 1){
                    int priority = calculatePriority(parseInt(o.get(2)), o.get(3), o.get(4), o.get(5));
                    String row = o.get(6).charAt(0) + "";
                    String column = o.get(6).charAt(1) + "";
                    Passenger newPassenger = new Passenger(o.get(0), o.get(1), parseInt(o.get(2)), o.get(5),priority, row, column);
                    table.hashInsert(newPassenger, newPassenger.getId());
                    System.out.println("Name: " + newPassenger.getName() + "\n" + "ID: " + newPassenger.getId() + "\n" + "Age: " + newPassenger.getAge() + "\n" + "Priority: " + newPassenger.getPriority() + "\n");
                }
            }

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        isLoaded = true;
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
