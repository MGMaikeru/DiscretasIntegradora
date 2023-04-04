package model;

import exception.EmptyFieldException;

public class Stack<T> {

    private Node1<T> top;
    private int size;

    private int totalValue;

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

    public void setTop(Node1<T> top) {
        this.top = top;
    }

    public void push(Node1<T> element){

        element.setNext(this.top);
        this.top = element;
        this.totalValue += element;
    }

    public Node1<T> pop2()  {
        Node1<T> toReturn = this.top;
        top = top.getNext(); // El nuevo tope será el siguiente elemento de la pila
        size--; // Se reduce el tamaño de la pila
        return toReturn;
    }

    public T pop() throws EmptyFieldException {
        if (isEmpty()) { // Si la pila está vacía, no se puede hacer pop
            throw new EmptyFieldException();
        }
        Node1<T> toReturn = this.top;
        top = top.getNext(); // El nuevo tope será el siguiente elemento de la pila
        size--; // Se reduce el tamaño de la pila
        return toReturn.getValue();
    }


}
