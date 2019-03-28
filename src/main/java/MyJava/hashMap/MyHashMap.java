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
    transient int hashSeed = 6;
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
            myEntry = ergodicMyEntry(table[0], key);
        } else {
            int index = lookIndex(hash(key), table.length - 1);
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
        //是否扩容
        expansionCapacity();
        if (key == null)
            return putForNull(key, value);
        int index = lookIndex(hash(key), table.length - 1);
        //    System.out.println("key:" + key + " hash:" + hash(key) + " index:" + index);
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
    private int lookIndex(int hash, int length) {
        return hash & length;
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
            if (myEntry.key != null) {
                if (myEntry.key.equals(key) || myEntry.key == key) {
                    return myEntry;
                }
            } else {
                if (key == null)
                    return myEntry;
            }
            myEntry = myEntry.next;
        }
        return null;
    }

    //这是一个神奇的函数，用了很多的异或，移位等运算，
    // 对key的hashcode进一步进行计算以及二进制位的
    // 调整等来保证最终获取的存储位置尽量分布均匀
    final int hash(Object k) {
        int h = hashSeed;
        h ^= k.hashCode();
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    private void expansionCapacity() {
        int c = (int) (table.length * loadFactor);
        if ((size + 1) > c && (table.length * 2) < MAXIMUM_CAPACITY) {
            MyEntry<K, V>[] newTable = new MyEntry[table.length * 2];
            for (MyEntry<K, V> entry : table) {
                if (entry != null) {
                    expansionCapacity(entry, newTable);
                }
            }
            table = newTable;
        }
    }

    private void expansionCapacity(MyEntry<K, V> entry, MyEntry<K, V>[] newTable) {
        while (entry != null) {
            int index = 0;
            if (entry.key != null) {
                index = lookIndex(hash(entry.key), newTable.length - 1);
            }
            if (newTable[index] != null) {
                MyEntry<K, V> add = addMyEntry(entry.key, entry.value);
                add.next = newTable[index];
                newTable[index] = add;
            } else {
                newTable[index] = addMyEntry(entry.key, entry.value);
            }
            entry = entry.next;
        }
    }

    @Override
    public void remove(K key) {

    }

    public void printMap() {
        for (int i = 0; i < table.length; i++) {
            System.out.print("I:" + i);
            printMyEntry(table[i]);
        }
    }

    public void printMyEntry(MyEntry<K, V> myEntry) {
        while (myEntry != null) {
            if (myEntry.key != null)
                System.out.print("-->> hash:" + hash(myEntry.key) + " K:" + myEntry.key + " V: " + myEntry.value);
            else
                System.out.print("-->> hash:" + null + " K:" + null + " V: " + myEntry.value);

            myEntry = myEntry.next;
        }
        System.out.println();
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