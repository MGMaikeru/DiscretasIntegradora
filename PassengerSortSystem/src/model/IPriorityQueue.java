package model;

public abstract class IPriorityQueue<T extends Comparable<T>> {
    public abstract T heapMaximum();
    public abstract T heapExtractMax();
    public abstract void heapIncreaseKey(int i, T key);
    public abstract void maxHeapInsert(T key);
}
