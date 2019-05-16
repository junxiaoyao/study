package javaCore1.part6.part6_2.part6_2_2;

import java.util.Comparator;

public class StringComparable implements Comparator<String> {
  @Override
  public int compare(String o1, String o2) {
    return o1.length() - o2.length();
  }
}
