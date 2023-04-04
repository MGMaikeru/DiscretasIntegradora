package model.Test;

import java.util.Collections;
import java.util.ArrayList;

public class Heap<T extends Comparable<T>> {

    private int heapSize;
    public Heap(){

    }

    public void heapSort(ArrayList<T> array){
        buildMaxHeap(array);
        for (int i = array.size(); i>=1; i--) {
            Collections.swap(array, 0, i - 1);
            reduceHeapSize();
            maxHeapify(0, array);
        }
    }

    public void buildMaxHeap(ArrayList<T> array){
        this.heapSize = array.size()-1;
        for (int i = (int)Math.floor(array.size()/2); i>=1; i--){
            maxHeapify(i-1, array);
        }
    }

    public void reduceHeapSize(){
        this.heapSize--;
    }

    public void maxHeapify(int index, ArrayList<T> array){
        int l = left(index);
        int r = right(index);
        System.out.println("HeapSize:" + heapSize);
        int largest = 0;

        if (l <= heapSize && array.get(l).compareTo(array.get(index))> 0) {
            largest = l;
        }else{
            largest = index;
        }

        if (r <= heapSize && array.get(r).compareTo(array.get(largest))> 0) {
            largest = r;
        }
        if (largest != index) {
            Collections.swap(array, index, largest);
            maxHeapify(largest, array);
        }
        return;
    }

    public int getHeapSize(ArrayList<T> array){
        int size = 0;
        for (int i = array.size();i>= 0; i--){
            if (father(i) != 0) {
                if (array.get((int)father(i)-1).compareTo(array.get(i-1)) >= 0){
                    size += 1;
                } else{
                    size = 0;
                }
            }

        }
        return size+1;
    }

    public int right(int index){
        return index*2+2;
    }

    public int left(int index){
        return index*2+1;
    }

    public double father(int index){
        return Math.floor(index/2);
    }
}
