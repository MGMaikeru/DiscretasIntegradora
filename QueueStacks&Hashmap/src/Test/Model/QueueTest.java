package Test.Model;
import exception.EmptyFieldException;
import model.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {
    private Queue<Contact, String> q;
    private Queue<Integer, String> q2;

    public void setup1 (){
        q = new Queue<>();
        q2 = new Queue<>();
    }

    public void setup2(){
        q = new Queue<>();
        Contact c1 = new Contact("contact1", "00", "contact1@correo.com");
        q.enqueue(new Node<>(c1, c1.getName()));
    }

    @Test
    public void isEmptyTest1(){
        setup1();
        assertTrue(q.isEmpty());
    }

    @Test
    public void isEmptyTest2(){
        setup1();
        Contact c1 = new Contact("contact1", "00", "contact1@correo.com");
        q.enqueue(new Node<>(c1, c1.getName()));

        assertFalse(q.isEmpty());
    }

    @Test
    public void isFrontTest1(){
        setup1();
        boolean isEmpty = false;
        try{
            q.getFront();
        }catch (EmptyFieldException e){
            isEmpty = true;
        }
        assertTrue(isEmpty);
    }

    @Test
    public void isFrontTest2(){
        setup1();
        Contact c1 = new Contact("contact1", "00", "contact1@correo.com");
        q.enqueue(new Node<>(c1, c1.getName()));
        Contact c2 = new Contact("contact2", "10", "contact2@correo.com");
        q.enqueue(new Node<>(c2, c2.getName()));

        try{
            assertEquals(c1, q.getFront());
        } catch(EmptyFieldException e){

        }

    }

    @Test
    public void isDequeueTest1(){
        setup1();
        boolean isEmpty = false;
        try{
            q.dequeue();
        }catch (EmptyFieldException e){
            isEmpty = true;
        }
        assertTrue(isEmpty);
    }

    @Test
    public void isDequeueTest2(){
        setup2();
        Contact c2 = new Contact("contact2", "10", "contact2@correo.com");
        q.enqueue(new Node<>(c2, c2.getName()));

        try{
            q.dequeue();
            assertEquals(c2, q.getFront());
        } catch(EmptyFieldException e){

        }

    }

    @Test
    public void isDequeueTest3(){
        setup2();
        Contact c2 = new Contact("contact2", "10", "contact2@correo.com");

        try{
            q.dequeue();
            q.enqueue(new Node<>(c2, c2.getName()));
            assertEquals(c2, q.getFront());
        } catch(EmptyFieldException e){

        }

    }

    @Test
    public void isDequeueTest4(){
        setup2();
        Contact c2 = new Contact("contact2", "10", "contact2@correo.com");
        q.enqueue(new Node<>(c2, c2.getName()));
        Contact c3 = new Contact("contact3", "15", "contact3@correo.com");
        q.enqueue(new Node<>(c3, c3.getName()));

        try{
            q.dequeue();
            q.dequeue();
            assertEquals(c3, q.getFront());
        } catch(EmptyFieldException e){

        }
    }

    @Test
    public void algorithm1(){
        setup1();
        int deckNumber = 7;
        for (int i = 1; i == deckNumber; i++){
            q2.enqueue(new Node<>(i, ""));
        }

        String discardedCards = "";

        try{

            while (q2.getFront() != q2.getLast()){
                discardedCards += q2.dequeue();
                q2.enqueue(q2.dequeue2());
            }
            System.out.println(discardedCards);
            System.out.println(q2.getFront());
        }catch(EmptyFieldException e){

        }

    }
}
