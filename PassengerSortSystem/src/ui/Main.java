package ui;

import exception.PassengerAlreadyConfirmedException;
import model.Controller;

import java.util.Scanner;

public class Main {
    private static Scanner input;
    private Controller c;

    public Main() {
        input = new Scanner(System.in);
        c = new Controller();
    }

    public static void main(String[] args) {
        System.out.println("<<<<< Passenger Sort System >>>>>");
        Main m = new Main();
        m.displayStartMenu();
    }

    public void displayStartMenu() {
        System.out.print("1)Import archive \n2)Confirm passenger assistance \n3)Generate ordered entry list \n4)Generate ordered exit list \n5) Exit\nSelected: ");
        int option = input.nextInt();
        executeOption(option);
    }

    public void executeOption(int option) {
        switch (option) {
            case 1:
                System.out.println(c.importDataFromCSV());

                break;
            case 2:
                System.out.println(confirmPassenger());
                break;
            case 3:
                showOrderEntryList();
                break;
            case 4:
                showOrderExistList();
                break;
            case 5:
                System.out.println("\nThanks for using the program. Until next time!");
                break;
            default:
                System.out.println("Error. Type a valid option.\n");
                break;
        }
        if (option != 5)
            displayStartMenu();

    }

    public String confirmPassenger(){
        System.out.println("Type the passenger ID: ");
        input.nextLine();
        String passengerID = input.nextLine();
        try {
            return c.confirmAssistance(passengerID);
        } catch (PassengerAlreadyConfirmedException e) {
               return e.getMessage();
        }
    }

    public void showOrderEntryList(){
        System.out.println(c.generateEntryList());
    }

    public void showOrderExistList(){
        System.out.println(c.addToExistList());
    }
}