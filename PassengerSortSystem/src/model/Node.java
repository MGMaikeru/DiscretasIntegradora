package model;

public class Node<T, K extends Comparable<K>> {

    private T value;
    private K key;

    private Node<T, K> next;
    private Node<T, K> back;
    public Node(T value, K key) {
        this.value = value;
        this.key = key;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public K getKey() {
        return key;
    }

    @Override
    public String toString(){
        return "My value is: " + value;
    }

    public Node<T, K> getNext() {
        return next;
    }

    public void setNext(Node<T, K> next) {
        this.next = next;
    }

    public void setBack(Node<T, K> back) {
        this.back = back;
    }

    public Node<T, K> getBack() {
        return back;
    }
}