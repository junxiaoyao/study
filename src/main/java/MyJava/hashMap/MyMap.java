package MyJava.hashMap;

public interface MyMap<K, V> {
    V put(K key, V value);

    void remove(K key);

    int size();

    V get(K key);

    boolean isEmpty();
}
