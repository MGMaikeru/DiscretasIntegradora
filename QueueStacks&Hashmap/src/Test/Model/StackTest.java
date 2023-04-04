package Test.Model;
import exception.EmptyFieldException;
import model.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

    private Stack<Contact, String> s;
    private Stack<Character, String> s2;
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
        setup1();
        Contact c1 = new Contact("contact1", "00", "contact1@correo.com");
        s.push(new Node<>(c1, c1.getName()));

        assertFalse(s.isEmpty());
    }

    @Test
    public void isTopTest1(){
        setup1();
        boolean isEmpty = false;
        try{
            s.getTop();
        }catch (EmptyFieldException e){
            isEmpty = true;
        }
        assertTrue(isEmpty);
    }

    @Test
    public void isTopTest2(){
        setup1();
        Contact c1 = new Contact("contact1", "00", "contact1@correo.com");
        s.push(new Node<>(c1, c1.getName()));
        Contact c2 = new Contact("contact2", "10", "contact2@correo.com");
        s.push(new Node<>(c2, c2.getName()));

        try{
            assertEquals(c2, s.getTop());
        } catch(EmptyFieldException e){

        }

    }

    @Test
    public void isPopTest1(){
        setup1();
        boolean isEmpty = false;
        try{
            s.pop();
        }catch (EmptyFieldException e){
            isEmpty = true;
        }
        assertTrue(isEmpty);
    }

    @Test
    public void isPopTest2(){
        setup1();
        Contact c1 = new Contact("contact1", "00", "contact1@correo.com");
        s.push(new Node<>(c1, c1.getName()));

        try{
            assertEquals(c1, s.pop());
        } catch(EmptyFieldException e){

        }

    }

    @Test
    public void case1(){
        setup1();
        String word = "Alexandro";

        for (int i = 0; i < word.length(); i++){
            s2.push(new Node<>(word.charAt(i), word));
        }
        String newWord = "";
        try{
            for (int i = 0; i < word.length(); i++){
                newWord += s2.pop();
            }
        }catch (EmptyFieldException e){

        }

        assertEquals("ordnaxelA", newWord);

    }
}
