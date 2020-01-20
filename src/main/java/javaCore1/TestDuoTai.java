package javaCore1;

/**
 * @description
 * @author: jxy
 * @create: 2020-01-17 15:29
 */
public class TestDuoTai {

    public static void main(String[] args) {

        Animal am = new Animal();
        System.out.println(am.num);
        am.eat();

        Animal amCat = new Cat();
        System.out.println(amCat.num);
        // System.out.println(amCat.age); 报错
        amCat.eat();
      amCat.say();
      Cat cat=(Cat)amCat;
      cat.say();
        // amCat.catchMouse(); 报错
    }
}

class Animal {

    int num = 10;

    public void eat() {
        System.out.println("动物吃饭");
    }

    public static void say() {
        System.out.println("jiao");
    }
}

class Cat extends Animal {

    int num = 80;

    int age = 10;

    public void eat() {
        System.out.println("猫吃饭");
    }

    public void catchMouse() {
        System.out.println("猫在抓老鼠");
    }
    public static void say() {
        System.out.println("miao");
    }
}