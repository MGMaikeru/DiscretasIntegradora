package ui;

import model.Controller;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static Scanner input;
    private Controller c;

    public Main() {
        input = new Scanner(System.in);
        c = new Controller();
    }

    public static void main(String[] args) {
        System.out.println("<<<<< Bienvenido a medallas del mundo >>>>>");
        Main m = new Main();
        //System.out.println(m.c.readJson());
        m.displayStartMenu();
    }

    public void displayStartMenu() {
        System.out.print("1) Import archive\n2) \n3) \n4) \n5) Exit\nSelected: ");
        int option = input.nextInt();
        executeOption(option);
    }

    public void executeOption(int option) {
        switch (option) {
            case 1:
                System.out.println(c.importDataFromCSV());

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

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
}