package thread.concurrent_study;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @description
 * @author: jxy
 * @create: 2020-06-05 15:58
 */
public class TestQueen {

  public static void main(String[] args) {
    LinkedBlockingQueue<User> students = new LinkedBlockingQueue<>();
    students.offer(new User("张三",18,"浙江杭州"));
    students.offer(new User("李四",20,"浙江杭州"));
    System.out.println();
  }
}
class User{
  private String name;
  private Integer age;
  private String address;

  public User(String name, Integer age, String address) {
    this.name = name;
    this.age = age;
    this.address = address;
  }
}