package javaCore1.part8;

public class Parts<T> {
    public T createT(Class<T> t)throws Exception{
      return (T)t.newInstance();
    }
}
