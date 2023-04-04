package  model;

import java.util.ArrayList;

public class HashTable<V, K extends Comparable<K>> {

    private ArrayList<Node<V, K>> table;
    private int size;

    public HashTable(int capacity) {
        table = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            table.add(null);
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void clear() {
        for (int i = 0; i < table.size(); i++) {
            table.set(i, null);
        }
        size = 0;
    }

    private int hash1(K key) {
        return key.hashCode() % table.size();
    }

    private int hash2(K key) {
        int prime = 7;
        return prime - (key.hashCode() % prime);
    }


    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Null key");
        }
        if (size >= table.size()) {
            throw new IllegalStateException("Table full");
        }
        int index = hash1(key);
        Node<V, K> entry = new Node<>(value, key);
        if (table.get(index) == null) {
            table.set(index, entry);
            size++;
        } else {
            int i = 1;
            int newIndex = 0;
            boolean isAdded = false;
            while (isAdded = false) {
                newIndex = (hash1(key) + i * hash2(key)) % table.size();
                if (table.get(newIndex) == null) {
                    table.set(index, entry);
                    size++;
                    isAdded = true;
                    System.out.println("El objeto se almaceno en:" + newIndex);
                }
                i++;
            }
            
        }
    }
}