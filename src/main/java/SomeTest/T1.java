package SomeTest;

import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: jxy
 * @Date: 2019/3/26 16:07
 * @Description:
 */
public class T1 {

    public static void main(String[] args) {
        // final byte a = 1;
        // final byte b = 2;
        // String str = "2.5";
        // System.out.println(Float.isNaN(Float.parseFloat(str)));
        HashSet set = new HashSet();
        Person p1 = new Person("Tom", 19);
        Person p2 = new Person("Liam", 15);
        set.add(p1);
        set.add(p2);
        System.out.println(set);
        p1.setName("Marin");
        set.remove(p1);
        System.out.println(set);
    }

}

class Person {

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override public String toString() {
        return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}
