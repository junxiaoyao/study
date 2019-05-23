package niuke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
// 使得所有的奇数位于数组的前半部分，
// 所有的偶数位于数组的后半部分，
// 并保证奇数和奇数，
// 偶数和偶数之间的相对位置不变。
public class T13 {

  public static void main(String[] args) {
    int[] nums = {4, 1, 3, 2};
    reOrderArray(nums);
    System.out.println(Arrays.toString(nums));
  }

  public static void reOrderArray(int[] array) {
    List<Integer> listJ = new ArrayList<>();
    List<Integer> listO = new ArrayList<>();
    for (int i = 0; i < array.length; i++) {
      if (array[i] % 2 != 0) {
        listJ.add(array[i]);
      } else {
        listO.add(array[i]);
      }
    }
    int[] num1 = null;
    if (listJ.size() > 0) {
      num1 = new int[listJ.size()];
      for (int i = 0; i < listJ.size(); i++) {
        num1[i] = listJ.get(i);
      }
    }
    int[] num2 = null;
    if (listO.size() > 0) {
      num2 = new int[listO.size()];
      for (int i = 0; i < listO.size(); i++) {
        num2[i] = listO.get(i);
      }
    }
    if (num1!=null)
    System.arraycopy(num1, 0, array, 0, listJ.size());
    if (num2!=null)
    System.arraycopy(num2, 0, array, listJ.size(), listO.size());
  }
}
