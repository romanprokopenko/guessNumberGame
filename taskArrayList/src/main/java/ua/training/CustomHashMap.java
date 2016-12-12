package ua.training;

import java.util.List;
import java.util.Set;

/**
 * Created by User on 09.12.2016.
 */
public class CustomHashMap<K, V> {

    private int size = 0;
    private int capacity = 16;
    private double loadFactor = 0.75;
    private double threshold = capacity * loadFactor;
    private Node<K,V>[] buckets = new Node[capacity];

    public boolean containsKey(K i) {
        return get(i)!=null;
    }

    public boolean containsValue(V i) {
        return true;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public void clear() {
    }

    public void putAll(CustomHashMap<V, V> map3) {
    }

    public Set<K> keySet() {
        return null;
    }

    public List<V> values() {
        return null;
    }


    private static class Node<K, V> {
        K key;
        V value;
        int hash;
        Node nextNode;

        public Node(K key, V value, int hash, Node nextNode) {
            this.key = key;
            this.value = value;
            this.hash = hash;
            this.nextNode = nextNode;
        }
    }

    public CustomHashMap() {
    }

    public CustomHashMap(int capacity) {
        this.capacity = capacity;
        this.threshold = capacity * this.loadFactor;
    }

    public CustomHashMap(int capacity, double loadFactor) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        this.threshold = capacity * loadFactor;
    }

    public V put(K key, V value) {
        int hash = hash(key);
        Node<K, V> currentNode = buckets[hash];
        if (currentNode == null) {
            buckets[hash] = new Node(key,
                    value, key.hashCode(), null);
            size++;
            return null;
        }
        Node<K, V> previousNode = currentNode;
        V previousValue = previousNode.value;
        while (currentNode != null) {
            previousNode = currentNode;
            previousValue = currentNode.value;
            if (key.equals(currentNode.key)) {
                currentNode.value = value;
                return previousValue;
            }
            currentNode = currentNode.nextNode;
        }
        previousNode.nextNode = new Node(key,
                                value, key.hashCode(), null);
        size++;
        return null;
    }

    public V get(K key) {
        int hash = hash(key);
        Node<K, V> currentNode = buckets[hash];
        while (currentNode != null) {
            if (key.equals(currentNode.key)) {
                return currentNode.value;
            }
            currentNode = currentNode.nextNode;
        }
        return null;
    }

    public V remove(K key) {
        int hash = hash(key);
        Node<K, V> currentNode = buckets[hash];
        Node<K, V> previousNode = null;
        while (currentNode != null) {
            if (key.equals(currentNode.key)) {
                if (previousNode != null) {
                    previousNode.nextNode = currentNode.nextNode;
                } else {
                    buckets[hash] = currentNode.nextNode;
                }
                size--;
                return currentNode.value;
            }
            previousNode = currentNode;
            currentNode = currentNode.nextNode;
        }
        return null;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

}
