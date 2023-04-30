package model;


import exception.InvalidNumberException;
import org.junit.jupiter.api.Test;

import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.exceptions;
import static org.junit.jupiter.api.Assertions.*;
public class PassengerTest {
    @Test
    public void PassengerCreatedSuccesfullyTest(){
        Passenger passenger = new Passenger("John", "123", 27, "TouristClass", 0, "1", "A");
        assertEquals("John", passenger.getName());
        assertEquals("123", passenger.getId());
        assertEquals(27, passenger.getAge());
        assertFalse(passenger.isConfirmed);
        assertEquals("", passenger.getConfirmationHour());
        assertEquals("1", passenger.getRow());
        assertEquals("A", passenger.getColumn());
    }
    @Test
    public void PassengerCreatedSuccessBTest(){
        boolean result = true;
        try{
            Passenger passenger2 = new Passenger("Jane", "456", 22, "TouristClass", 10, "1", "B");
            result = false;
        }catch (InvalidNumberException ex){
            ex.printStackTrace();
        }
        assertFalse(result);
    }
    @Test
    public void ConfirmAssistanceTest() {
        Passenger passenger3 = new Passenger("Mary", "111", 30, "BusinessClass", 20, "3", "C");
        assertFalse(passenger3.isConfirmed);
        passenger3.confirmAssistance();
        assertTrue(passenger3.isConfirmed);
    }
    @Test
    public void CompareToPassengerPriorityTest() {
        Passenger passenger1 = new Passenger("Mary sue", "456", 20, "BusinessClass", 30, "10", "A");
        Passenger passenger2 = new Passenger("Gary Stu", "123", 21, "TouristClass", 50, "20", "B");
        Passenger passenger3 = new Passenger("John Shepard", "777", 29, "FirstClass", 70, "7", "N");
        assertTrue(passenger1.compareTo(passenger2) < 0);
        assertTrue(passenger2.compareTo(passenger1) > 0);
        assertTrue(passenger1.compareTo(passenger3) < 0);
        assertTrue(passenger3.compareTo(passenger1) > 0);
        assertTrue(passenger2.compareTo(passenger3) < 0);
        assertTrue(passenger3.compareTo(passenger2) > 0);
    }



}
