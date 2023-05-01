package model;
import exception.*;

public class Stack<T> {

    private StackNode<T> top;
    private int size;

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.top == null;
    }

    public T getTop2() {
        return top.getValue();
    }

    public T getTop() throws EmptyFieldException{
        if (top == null) {
            throw new EmptyFieldException();
        }
        return top.getValue();
    }

    public void setTop(StackNode<T> top) {
        this.top = top;
    }

    public void push(StackNode<T> element){

        element.setNext(this.top);
        this.top = element;
    }

    public StackNode<T> pop2()  {
        StackNode<T> toReturn = this.top;
        top = top.getNext(); // The new top will be the next item on the stack
        size--; // Reduce the size of the stack
        return toReturn;
    }

    public T pop() throws EmptyFieldException {
        if (isEmpty()) { // If the stack is empty, you can't pop
            throw new EmptyFieldException();
        }
        StackNode<T> toReturn = this.top;
        top = top.getNext(); // The new top will be the next item on the stack
        size--; // Reduce the size of the stack
        return toReturn.getValue();
    }


}
