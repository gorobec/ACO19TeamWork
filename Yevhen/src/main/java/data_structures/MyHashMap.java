package data_structures;

import java.util.Map;

/**
 * Created by gorobec on 20.05.17.
 */
public class MyHashMap<K,V> implements MyMap<K,V> {

    private Entry<K,V>[] threshold;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private int size;
    private static final int INITIAL_CAPACITY = 16;
    private float loadFactor;
    private int capacity;

    public MyHashMap() {
        this(INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap(int capacity) {
        this(capacity, DEFAULT_LOAD_FACTOR);
    }

    @SuppressWarnings(value = "unchecked")
    public MyHashMap(int capacity, float loadFactor) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        this.threshold = (Entry<K,V>[]) new Entry[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public V put(K key, V value) {

        int position = findPosition(key);

        Entry<K, V> iter = threshold[position];
        Entry<K, V> previous = iter;

        if(iter == null){
            threshold[position] = new Entry<>(key, value);
            size++;
            resize();
            return null;
        }

        while (iter != null) {
            if(iter.key.equals(key)){
                V oldValue = iter.value;
                iter.value = value;
                return oldValue;
            }
            previous = iter;
            iter = iter.next;
        }
//        TODO check why could be NOT initialized
        previous.next = new Entry<>(key, value);
        size++;
        resize();
        return null;
    }

    @SuppressWarnings(value = "unchecked")
    private void resize() {
        if(size  < capacity * loadFactor) return;
        capacity = capacity * 2;
        Entry<K, V>[] oldThreshold = this.threshold;
        this.threshold = (Entry<K, V> []) new Entry[capacity];
        size = 0;
        for (int i = 0; i < oldThreshold.length; i++) {
            if(oldThreshold[i] == null) continue;
            while (oldThreshold[i] != null){
                put(oldThreshold[i].key, oldThreshold[i].value);
                oldThreshold[i] = oldThreshold[i].next;
            }
        }
    }

    private int findPosition(K key) {
        return key.hashCode() % capacity;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public boolean remove(K key, V value) {
        return false;
    }

    @Override
    public MySet<K> keySet() {
        return null;
    }

    @Override
    public MyCollection<V> values() {
        return null;
    }

    public static class Entry<K,V>{

        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
