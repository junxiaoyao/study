package readmeStudy.sort;

import java.io.InputStream;
import java.util.Arrays;

/**
 * @description
 * @author: jxy
 * @create: 2019-06-20 09:41
 */
public class InsertSort {

  public static void main(String[] args) {
    int[] nums = {10,4,11, 9, 8};
    insert_sort(nums);
  }

  //插入排序
  public static void insert_sort(int[] nums) {
    System.out.println(Arrays.toString(nums));
    for (int i = 1; i < nums.length; i++) {
      System.out.println(i);
      int temp = nums[i];
      int j;
      for (j = i - 1; j >= 0; j--) {
        // 将大于temp的往后移动一位
        if (nums[j] > temp) {
          nums[j + 1] = nums[j];
        } else {
          break;
        }
      }
      nums[j + 1] = temp;

    }
    System.out.println(Arrays.toString(nums));
  }
}
