package model;

public class StackNode<T> {

    private T value;

    private StackNode<T> next;
    private StackNode<T> back;
    public StackNode(T value) {
        this.value = value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }


    @Override
    public String toString(){
        return "My value is: " + value;
    }

    public StackNode<T> getNext() {
        return next;
    }

    public void setNext(StackNode<T> next) {
        this.next = next;
    }

    public void setBack(StackNode<T> back) {
        this.back = back;
    }

    public StackNode<T> getBack() {
        return back;
    }
}
