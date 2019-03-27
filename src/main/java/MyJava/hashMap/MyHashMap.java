package MyJava.hashMap;

import java.security.Key;

/**
 * @Auther: jxy
 * @Date: 2019/3/27 21:04
 * @Description:
 */
public class MyHashMap<K, V> implements MyMap<K, V> {
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
    static final int MAXIMUM_CAPACITY = 1 << 30;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private int size;
    transient int hashSeed = 0;
    MyEntry<K, V>[] table;
    private float loadFactor;
    private int initCapacity;

    public MyHashMap() {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap(int initCapacity, float loadFactor) {
        if (initCapacity < 0)
            throw new IllegalArgumentException("初始值不能不合法,initCapacity：" + initCapacity);
        if (loadFactor <= 0 || Float.isNaN(loadFactor))
            throw new IllegalArgumentException("Illegal load factor: " + loadFactor);
        if (initCapacity > MAXIMUM_CAPACITY)
            initCapacity = MAXIMUM_CAPACITY;
        this.initCapacity = initCapacity;
        this.loadFactor = loadFactor;
    }

    @Override
    public V get(K key) {
        MyEntry<K, V> myEntry;
        if (key == null) {
            myEntry = table[0];
        } else {
            int index = lookIndex(key.hashCode(), table.length - 1);
            myEntry = ergodicMyEntry(table[index], key);
        }
        if (myEntry != null)
            return myEntry.value;
        return null;
    }

    @Override
    public V put(K key, V value) {
        if (table == null)
            table = new MyEntry[initCapacity];
        if (key == null)
            return putForNull(key, value);
        int index = lookIndex(key.hashCode(), table.length - 1);
        System.out.println("key:"+key+" hashcode:"+key.hashCode()+ " index:"+index);
        if (table[index] != null) {
            MyEntry<K, V> myEntry = ergodicMyEntry(table[index], key);
            if (myEntry != null) {
                V oldValue = myEntry.value;
                myEntry.value = value;
                return oldValue;
            } else {
                MyEntry newMyEntry = addMyEntry(key, value);
                newMyEntry.next = table[index];
                table[index] = newMyEntry;
                size++;
            }
        } else {
            table[index] = addMyEntry(key, value);
            size++;
        }

        return null;
    }

    //得到下标
    private int lookIndex(int hashcode, int length) {
        return hashcode & length;
    }

    private V putForNull(K key, V value) {
        if (table[0] != null) {
            MyEntry<K, V> myEntry = ergodicMyEntry(table[0], key);
            if (myEntry != null) {
                V oldValue = myEntry.value;
                myEntry.value = value;
                return oldValue;
            } else {
                MyEntry newMyEntry = addMyEntry(key, value);
                newMyEntry.next = table[0];
                table[0] = newMyEntry;
                size++;
            }
        } else {
            table[0] = addMyEntry(key, value);
            size++;
        }
        return null;
    }

    private MyEntry<K, V> addMyEntry(K key, V value) {
        return new MyEntry<K, V>(key, value);
    }

    //遍历节点
    private MyEntry<K, V> ergodicMyEntry(MyEntry<K, V> myEntry, K key) {
        while (myEntry != null) {
            if (myEntry.key.equals(key) || myEntry.key == key) {
                return myEntry;
            }
            myEntry = myEntry.next;
        }
        return null;
    }

    /* //这是一个神奇的函数，用了很多的异或，移位等运算，对key的hashcode进一步进行计算以及二进制位的调整等来保证最终获取的存储位置尽量分布均匀
     final int hash(Object k) {
         int h = hashSeed;
         if (0 != h && k instanceof String) {
             return sun.misc.Hashing.stringHash32((String) k);
         }

         h ^= k.hashCode();

         h ^= (h >>> 20) ^ (h >>> 12);
         return h ^ (h >>> 7) ^ (h >>> 4);
     }*/
    @Override
    public void remove(K key) {

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}

class MyEntry<K, V> {
    K key;
    V value;
    MyEntry<K, V> next;
    int hash;

    public MyEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public MyEntry(K key, V value, MyEntry<K, V> next, int hash) {
        this.key = key;
        this.value = value;
        this.next = next;
        this.hash = hash;
    }
}