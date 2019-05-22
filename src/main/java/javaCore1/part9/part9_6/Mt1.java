package javaCore1.part9.part9_6;

import java.util.BitSet;

public class Mt1 {

  public static void main(String[] args) {
    int n = 100;
    long start = System.currentTimeMillis();
    BitSet bitSet = new BitSet(n + 1);
    int count = 0;
    int i;
    for (i = 2; i <= n; i++) {
      bitSet.set(i);
    }
    i = 2;
    while (i * i <= n) {
      if (bitSet.get(i)) {
        count++;
        int k = 2 * i;
        while (k <= n) {
          bitSet.clear(k);
          k += i;
        }
      }
      i++;
    }
    while (i <= n) {
      if (bitSet.get(i)) {
        count++;
      }
      i++;
    }
    long end = System.currentTimeMillis();
    System.out.println((end - start) + " mills");
    System.out.println(count);
    int cs=0;
    for (int j = 2; j <= n; j++) {
      if (bitSet.get(j)) {
        cs++;
        System.out.print(j+" ");
        if (cs % 10 == 0) {
          System.out.println();
        }
      }
    }
  }
}
