package test.model;

import exception.PassengerAlreadyConfirmedException;
import model.Controller;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ControllerTest {
    private Controller controller;
    //Controller setup
    public void setup1() {
        controller = new Controller();
    }

    @Test
    public void ConfirmAssistancePassengerNotFoundTest() {
        setup1();
        String id = "123";
        String ex = "Passenger ID hasn't been found.";
        String a = null;
        try {
            a = controller.confirmAssistance(id);
        } catch (PassengerAlreadyConfirmedException e) {
            throw new RuntimeException(e);
        }
        assertEquals(ex, a);
    }

    @Test
    public void GenerateEntryListNotConfirmedPassengersTest() {
        setup1();
        String ex = "There aren´t confirmed passengers yet";
        String list = controller.generateEntryList();
        assertEquals(ex, list);
    }

    @Test
    public void AddToExistListNotConfirmedPassengersTest() {
        setup1();
        String ex = "There aren´t confirmed passengers!";
        String list = controller.addToExistList();
        assertEquals(ex, list);
    }

    @Test
    public void ImportDataFromCSVLoadedTest() {
        setup1();
        String ex = "Successful import!";
        String a = controller.importDataFromCSV();
        assertEquals(ex, a);
        //If the data tries to be loaded again.
        ex = "The data base has already loaded!";
        a = controller.importDataFromCSV();
        assertEquals(ex, a);
    }
}
