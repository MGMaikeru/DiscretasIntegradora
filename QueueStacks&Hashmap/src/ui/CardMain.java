package ui;

import exception.EmptyFieldException;
import model.Node;

import model.Queue;
public class CardMain {
    private static Queue<Integer, Integer> q2;

    public static void main(String[] args) {
        q2 = new Queue<>();
        q2.enqueue(new Node<>(1, 1));
        q2.enqueue(new Node<>(2, 2));
        q2.enqueue(new Node<>(3, 3));
        q2.enqueue(new Node<>(4, 4));
        q2.enqueue(new Node<>(5, 5));
        q2.enqueue(new Node<>(6, 6));
        q2.enqueue(new Node<>(7, 7));
        String discardedCards = "";


        System.out.println("Tamaño actual de la cola: " + q2.getSize());


        try {
            while(q2.getSize()!=1) {
                discardedCards += q2.dequeue() + " ";
                q2.enqueue(q2.dequeue2());
            }
            System.out.println("Discarded cards: " + discardedCards);
            System.out.println("Remaining card: " + q2.getLast());
        } catch (EmptyFieldException e) {

        }
    }
}

