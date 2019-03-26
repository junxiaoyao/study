package MyJava;

import java.util.Arrays;

/**
 * @Auther: jxy
 * @Date: 2019/3/26 9:22
 * @Description:
 */
public class MyArrayList<E> implements MyList<E> {
    //元素数组
    private Object[] elementData;
    //实际长度
    private int size;
    //默认容量
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            elementData = new Object[DEFAULT_CAPACITY];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }

    @Override
    public boolean add(E e) {
        ensureCapacity(size + 1);
        elementData[size++] = e;
        return true;
    }

    @Override
    public E get(int index) {
        ensureIndex(index);
        return (E) elementData[index];
    }

    private void ensureIndex(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Illegal index: " + index);
        }
    }

    private void rangeIndex(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException("Illegal index: " + index);
        }
    }

    private void ensureCapacity(int minCapacity) {
        if (size == elementData.length) {
            int oldCapacity = elementData.length;
            int newCapacity = oldCapacity + oldCapacity >> 1;
            if (newCapacity - minCapacity < 0)
                newCapacity = minCapacity;
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    }

    @Override
    public boolean add(int index, E e) {
        rangeIndex(index);
        ensureCapacity(size + 1);
        int yd = size - index;
        System.arraycopy(elementData, index, elementData, index + 1, yd);
        elementData[index] = e;
        size++;
        return true;
    }

    @Override
    public E remove(int index) {
        ensureIndex(index);
        E e = get(index);
        int yd = size - index - 1;
        if (yd > 0)
            System.arraycopy(elementData, index + 1, elementData, index, yd);
        elementData[--size] = null;
        return e;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(o)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }
}
