package data_structures;

/**
 * Created by gorobec on 20.05.17.
 */
public interface MyMap<K, V> {

    int size();

    V put(K key, V value);

    V get(K key);

    boolean containsKey(Object key);

    boolean containsValue(Object value);

    V remove(K key);

    boolean remove(K key, V value);

    MySet<K> keySet();

    MyCollection<V> values();
}
