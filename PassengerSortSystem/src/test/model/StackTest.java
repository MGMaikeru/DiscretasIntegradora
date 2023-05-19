package test.model;
import exception.EmptyFieldException;
import model.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

    private Stack<Passenger> s;
    private Stack<Character> s2;
    public void setup1 (){
        s = new Stack<>();
        s2 = new Stack<>();
    }

    @Test
    public void isEmptyTest1(){
        setup1();
        assertTrue(s.isEmpty());
    }

    @Test
    public void isEmptyTest2(){
        //Se espera que la pila no este vacia, pues hay un elemento en el tope
        setup1();
        Passenger p1 = new Passenger("Mary sue", "456", 20, "BusinessClass", 30, "10", "A");
        s.push(new StackNode<>(p1));

        assertFalse(s.isEmpty());
    }

    @Test
    public void isEmptyTest3(){
        setup1();
        Passenger p1 = new Passenger("Mary sue", "456", 20, "BusinessClass", 30, "10", "A");
        s.push(new StackNode<>(p1));
        assertFalse(s.isEmpty());

        try{
            s.pop();
        }catch (EmptyFieldException e){

        }
        assertTrue(s.isEmpty());
    }

    @Test
    public void isTopTest1(){
        //Se intenta obtener el elemento en el tope de una pila vacia, obteniendo una excepcion
        setup1();

        try{
            s.getTop();
            fail("Se arroja un excepcion pues la pila esta vacia");
        }catch (EmptyFieldException e){

        }

    }

    @Test
    public void isTopTest2(){
        //Se agregan dos elementos, de forma que el que esta en el tope deberia de ser el segundo elemento
        setup1();
        Passenger p1 = new Passenger("Mary sue", "456", 20, "BusinessClass", 30, "10", "A");
        s.push(new StackNode<>(p1));
        Passenger p2 = new Passenger("Jane", "456", 22, "TouristClass", 10, "1", "B");
        s.push(new StackNode<>(p2));

        try{
            assertEquals(p2, s.getTop());
        } catch(EmptyFieldException e){

        }

    }

    @Test
    public void isPopTest1(){
        //Se intenta hacer pop a una pila vacia, esta deberia de arrojar un excepcion
        setup1();
        try{
            s.pop();
            fail("Se arroja un excepcion pues la pila esta vacia");
        }catch (EmptyFieldException e){

        }
    }

    @Test
    public void isPopTest2(){
        setup1();
        Passenger p1 = new Passenger("Mary sue", "456", 20, "BusinessClass", 30, "10", "A");
        s.push(new StackNode<>(p1));

        try{
            assertEquals(p1, s.pop());
        } catch(EmptyFieldException e){

        }

    }

    @Test
    public void isPopTest3(){
        //Se agregan dos elementos, de forma que el que esta en el tope deberia de ser el segundo elemento
        setup1();
        Passenger p1 = new Passenger("Mary sue", "456", 20, "BusinessClass", 30, "10", "A");
        s.push(new StackNode<>(p1));
        Passenger p2 = new Passenger("Jane", "456", 22, "TouristClass", 10, "1", "B");
        s.push(new StackNode<>(p2));

        try{
            assertEquals(p2, s.pop());
            assertEquals(p1, s.getTop());
        } catch(EmptyFieldException e){

        }

    }
}
