package  model;

import java.util.ArrayList;
import java.lang.Math;

public class HashMap<V, K extends Comparable<K>> extends IHashTable<V, K> {

    private ArrayList<Node<V, K>> table;
    private int size;
    private int capacity;
    private Node<V, K> deleted;

    public HashMap(int capacity) {
        table = new ArrayList<>();
        this.capacity = capacity;
        size = 0;
        for (int i = 0; i < capacity; i++){
            table.add(null);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void hashInsert(V value, K key){
        int tried = 0;
        if (key == null) {
            throw new IllegalArgumentException("Null key");
        }
        while (tried != (capacity*2)){
            int j = hash(key, tried);
            if (table.get(j) == null || table.get(j).equals(deleted)) {
                table.set(j, new Node<>(value, key));
                size++;
                return;
            }
            tried += 1;
        }
        throw new IllegalStateException("Table full");
    }

    @Override
    public V hashSearch(K key){
        if (key == null) {
            throw new IllegalArgumentException("Null key");
        }
        int tried = 0;
        int j = 0;
        Node<V, K> temporal = null;
        while (tried != capacity){
            j = hash(key, tried);
            temporal = table.get(j);
            if (temporal != null && temporal.getKey().equals(key)) {
                return temporal.getValue();
            }
            tried += 1;
        }

        return null;
    }

    public void delete(K key) {
        int tried = 0;
        int j = 0;
        while (tried != capacity){
            j = hash(key, tried);
            if (table.get(j)!= null && table.get(j).getKey().compareTo(key) == 0) {
                table.set(j, deleted);
                size--;
                return;
            }
            tried += 1;
        }
        return;
    }

    private int hash(K key, int tried) {
        return (Math.abs( hash1(key) + tried*hash2(key) ) ) % capacity;
    }

    private int hash1(K key) {
        double A = 0.6180339887; //Golden number
        int hashValue = key.hashCode();
        hashValue = (int) ((hashValue * A - Math.floor(hashValue * A)) * capacity);
        return hashValue;
    }

    private int hash2(K key) {
        return key.hashCode() % this.capacity;
    }

    public void printArray(){
        for (Node<V, K> o: table) {
            System.out.println(o);
        }
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
            while (!isAdded) {
                newIndex = (hash1(key) + i * hash2(key)) % table.size();
                if (table.get(newIndex) == null) {
                    table.set(index, entry);
                    size++;
                    isAdded = true;
                    System.out.println("The object is stored in:" + newIndex);
                }
                i++;
            }
            
        }
    }
}