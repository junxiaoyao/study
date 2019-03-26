package MyJava;

public interface MyList<E> {
    boolean add(E e);

    boolean add(int index, E e);

    E remove(int index);

    E get(int index);

    boolean remove(Object o);
}
