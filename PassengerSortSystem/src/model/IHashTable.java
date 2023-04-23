package model;

public abstract class IHashTable<V, K extends Comparable<K>>{

    public abstract void hashInsert(V value, K key);

    public abstract V hashSearch(K key);

    public abstract void delete(K key);
    
    
}
