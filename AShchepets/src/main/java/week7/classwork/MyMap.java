package week7.classwork;

/**
 * Created by SmooZzzie on 20.05.2017.
 */
public interface MyMap<K,V> {

    int size();

    V put(K key, V value);

    V get(K key);

    boolean containsKey(K key);

    V remove(K key);

    boolean remove(K key, V value);

}
