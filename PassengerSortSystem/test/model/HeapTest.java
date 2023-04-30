package model;
import model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HeapTest {

    @Test
    public void InsertElementTest() {
        Heap<Integer> h1 = new Heap<>();
        h1.insertElement(1);
        h1.insertElement(2);
        h1.insertElement(3);
        assertEquals("[1, 2, 3]", h1.getArray().toString());
    }

    @Test
    public void HeapMaximumTest() {
        Heap<Integer> h1 = new Heap<>();
        h1.insertElement(6);
        h1.insertElement(5);
        h1.insertElement(4);
        assertEquals(6, (int)h1.heapMaximum());
    }

    @Test
    public void HeapExtractMaxTest() {
        Heap<Integer> h2 = new Heap<>();
        h2.insertElement(4);
        h2.insertElement(3);
        h2.insertElement(2);
        assertEquals(4, (int)h2.heapExtractMax());
        assertEquals("[2, 3]", h2.getArray().toString());
    }

    @Test
    public void HeapIncreaseKeyTest() {
        Heap<Integer> h1 = new Heap<>();
        h1.insertElement(5);
        h1.insertElement(7);
        h1.insertElement(1);
        h1.heapIncreaseKey(2, 9);
        assertEquals("[9, 5, 7]", h1.getArray().toString());
    }

    @Test
    public void MaxHeapInsertTest() {
        Heap<Integer> h1 = new Heap<>();
        h1.insertElement(5);
        h1.insertElement(7);
        h1.insertElement(1);
        h1.maxHeapInsert(9);
        assertEquals("[9, 5, 1, 7]", h1.getArray().toString());
    }

    @Test
    public void HeapSortTest() {
        Heap<Integer> h2 = new Heap<>();
        h2.insertElement(5);
        h2.insertElement(7);
        h2.insertElement(1);
        h2.heapSort();
        assertEquals("[1, 5, 7]", h2.getArray().toString());
    }

    @Test
    public void BuildMaxHeapTest() {
        Heap<Integer> h1 = new Heap<>();
        h1.insertElement(5);
        h1.insertElement(7);
        h1.insertElement(1);
        h1.buildMaxHeap();
        assertEquals("[7, 5, 1]", h1.getArray().toString());
    }

}
