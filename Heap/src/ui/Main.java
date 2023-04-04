package ui;
import java.util.ArrayList;
import model.Test.Heap;

public class Main {

    private ArrayList<Integer> num;
    private Heap<Integer> heap;

    public Main(){
        num = new ArrayList<>();
        heap = new Heap<>();
    }
    public static void main(String[] args) {
        Main m = new Main();
        m.num.add(16);
        m.num.add(14);
        m.num.add(10);
        m.num.add(8);
        m.num.add(7);
        m.num.add(9);
        m.num.add(3);
        m.num.add(2);
        m.num.add(4);
        m.num.add(1);
        m.heap.heapSort(m.num);

        for (int i = 0; i<m.num.size();i++){
            System.out.println(m.num.get(i));
        }
    }
}