package javaCore1.part6.part6_2.part6_2_2;

import java.util.Arrays;
import java.util.Comparator;

public class Mt {

  public static void main(String[] args) {
    String[] strings={"asdsad","sa","ssssssssss","sadasdczxc"};
    Comparator<String> comparator=(o1,o2)->o1.length()-o2.length();
    Arrays.sort(strings,(o1,o2)->o1.length()-o2.length());
    System.out.println(Arrays.deepToString(strings));
  }
}
