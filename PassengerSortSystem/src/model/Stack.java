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
        top = top.getNext(); // El nuevo tope será el siguiente elemento de la pila
        size--; // Se reduce el tamaño de la pila
        return toReturn;
    }

    public T pop() throws EmptyFieldException {
        if (isEmpty()) { // Si la pila está vacía, no se puede hacer pop
            throw new EmptyFieldException();
        }
        StackNode<T> toReturn = this.top;
        top = top.getNext(); // El nuevo tope será el siguiente elemento de la pila
        size--; // Se reduce el tamaño de la pila
        return toReturn.getValue();
    }


}
