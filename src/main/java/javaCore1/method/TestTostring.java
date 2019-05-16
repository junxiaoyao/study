package javaCore1.method;

import java.util.Arrays;

public class TestTostring {

  public static void main(String[] args) {

    int[] nums = {1, 2, 3, 4, 3, 5, 6};
    int[] nums2 = {1, 6, 2, 3, 4, 3, 5, 6};
    int[][] num = {nums, nums2};
    Integer s=new Integer(5);
    System.out.println(Integer.toString(5,50));
    int sI=s;
    System.out.println(Arrays.toString(nums));
    System.out.println(Arrays.deepToString(num));
  }
}
