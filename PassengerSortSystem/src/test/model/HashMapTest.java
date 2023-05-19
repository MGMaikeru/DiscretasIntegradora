package test.model;

import model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HashMapTest {
    private HashMap<Passenger, String> hashMap;

    public void setup1 (){
        hashMap = new HashMap<>(10);
    }

    public void setup2 (){
        hashMap = new HashMap<>(5);
        Passenger p1 = new Passenger("Mary sue", "456", 20, "BusinessClass", 30, "10", "A");
        hashMap.hashInsert(p1, p1.getName());
        Passenger p2 = new Passenger("Mary on a cross", "111", 17, "BusinessClass", 20, "11", "A");
        hashMap.hashInsert(p2, p2.getName());
        Passenger p4 = new Passenger("Oscar", "432", 18, "EconomicClass", 20, "22", "C");
        hashMap.hashInsert(p4, p4.getName());
        Passenger p5 = new Passenger("Makoto", "555", 17, "FirstClass", 40, "15", "B");
        hashMap.hashInsert(p5, p5.getName());
    }

    @Test
    public void isEmptyTest(){
        setup1();
        assertTrue(hashMap.isEmpty());
    }

    @Test
    public void isEmptyTest2(){
        setup1();
        Passenger p1 = new Passenger("Gary", "112", 20, "BusinessClass", 10, "10", "G");
        hashMap.hashInsert(p1, p1.getName());

        assertFalse(hashMap.isEmpty());
    }

    @Test
    public void insertTest1(){
        setup1();
        Passenger p1 = new Passenger("Gary stu", "112", 20, "BusinessClass", 10, "10", "G");
        try{
            hashMap.hashInsert(p1, p1.getName());
        }catch(IllegalStateException e){}
        assertEquals(hashMap.size(), 1);
    }

    @Test
    public void insertTest2(){
        //Se intenta agregar un elemento a una tabla llena, debe arrojar un excepcion y mantener el mismo tamaño
        setup2();
        Passenger p6 = new Passenger("John Shepard", "777", 29, "FirstClass", 70, "7", "N");
        try{
            hashMap.hashInsert(p6, p6.getName());
        }catch(IllegalStateException e){
            assertEquals(hashMap.size(), 5);
        }
    }

    @Test
    public void insertTest3(){
        //Se intenta agregar un elemento con key vacia, debe arrojar un excepcion y mantener tamaño incial
        setup1();
        Passenger p6 = new Passenger("John Shepard", "777", 29, "FirstClass", 70, "7", "N");
        try{
            hashMap.hashInsert(p6, p6.getName());
        }catch(IllegalArgumentException e){
            assertEquals(hashMap.size(), 0);
        }
    }

    @Test
    public void hashSearchTest1(){
        //Se inserta un objeto y posteriormente se busca, devolviendo su valor
        setup2();
        Passenger p3 = new Passenger("John", "123", 27, "TouristClass", 0, "1", "A");
        hashMap.hashInsert(p3, p3.getName());
        assertEquals(p3, hashMap.hashSearch(p3.getName()) );
    }

    @Test
    public void hashSearchTest2(){
        //Se busca un objeto que no ha sido insertado en la tabla, esperando un null como resultado
        setup2();
        Passenger p6 = new Passenger("John Shepard", "777", 29, "FirstClass", 70, "7", "N");
        assertNull(hashMap.hashSearch(p6.getName()));
    }

    @Test
    public void hashSearchTest3(){
        //Se intenta buscar un elemento con una clave vacia
        setup2();
        try{
            hashMap.hashSearch("");
        }catch(IllegalArgumentException e){
            fail("Se espera que el metodo arroje una excepcion, ya que la llave de bsuqueda es nula");
        }
    }

    @Test
    public void deleteTest1(){
        //Se elimina un nodo, de forma que el tamaño del hashMap deberia de reducir se
        setup2();
        hashMap.delete("Mary sue");
        assertEquals(3, hashMap.size());
    }

    @Test
    public void deleteTest2(){
        //Se elimina un nodo y posteriormente se busca, de forma que la busqueda deberia de retornar null
        setup2();
        hashMap.delete("Mary sue");
        assertNull(hashMap.hashSearch("Mary sue"));
    }

    @Test
    public void deleteTest3(){
        //Se elimina un elemento y se agrega un nodo en el elemento que se elimino, de modo que el tamaño deberia de aumentar
        setup2();
        hashMap.delete("Oscar");
        Passenger p6 = new Passenger("John Shepard", "777", 29, "FirstClass", 70, "7", "N");
        Passenger p7 = new Passenger("Jane Shepard", "777", 29, "FirstClass", 70, "7", "N");
        hashMap.hashInsert(p6, p6.getName());
        hashMap.hashInsert(p7, p7.getName());
        assertEquals(5, hashMap.size());
    }
}
