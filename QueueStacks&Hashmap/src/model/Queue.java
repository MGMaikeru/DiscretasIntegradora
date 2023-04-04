package model;

import exception.EmptyFieldException;

public class Queue<T, K extends Comparable<K>> {

    private Node<T, K> front;
    private Node<T, K> last;
    private int size;

    public Queue() {
        this.front = null;
        this.last = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.front == null;
    }

    public T getFront() throws EmptyFieldException{
        if (front == null) {
            throw new EmptyFieldException();
        }
        return front.getValue();
    }

    public T getLast() {
        return last.getValue();
    }

    public void setFront(Node<T, K> front) {
        this.front = front;
    }

    public int getSize() {
        return size;
    }

    public void enqueue(Node<T, K> newNode){
        if (this.front == null) {
            this.front = newNode;
            this.size++;
            return;
        } else if(this.front != null && this.last == null){
            this.last =newNode;
            this.front.setBack(this.last);
            this.size++;
            return;
        }else {
            newNode.setNext(this.last);
            this.last = newNode;
            this.last.getNext().setBack(this.last);
            this.size++;
        }
        System.out.println(this.front.getValue());
    }

    public T dequeue() throws EmptyFieldException{
        if (isEmpty()) { // Si la cola está vacía, no se puede hacer desencolar
            throw new EmptyFieldException();
        }
        Node<T, K> toReturn = this.front;
        this.front = front.getBack(); // El nuevo frente será el siguiente elemento de la cola
        this.front.setNext(new Node<>(null, null)); //Se coloca el siguientye null para realizar la desconexion
        size--; // Se reduce el tamaño de la cola
        return toReturn.getValue();
    }

    public Node<T, K> dequeue2() throws EmptyFieldException{
        if (isEmpty()) { // Si la cola está vacía, no se puede hacer desencolar
            throw new EmptyFieldException();
        }
        Node<T, K> toReturn = this.front;
        this.front = front.getBack(); // El nuevo frente será el siguiente elemento de la cola
        this.front.setNext(new Node<>(null, null)); //Se coloca el siguientye null para realizar la desconexion
        size--; // Se reduce el tamaño de la cola
        return toReturn;
    }
}

