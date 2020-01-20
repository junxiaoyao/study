package SomeTest.some_sort;

import java.util.Arrays;

/**
 * @description
 * @author: jxy
 * @create: 2020-01-20 14:09
 */
public class TestInsertSort {

    public static void main(String[] args) {
        int[] nums = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};
        System.out.println(Arrays.toString(nums));
         insertSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    // 冒泡排序
    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                int temp = nums[j];
                if (temp < nums[i]) {
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
    }

    // 插入排序
    public static void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            // 待插入元素
            int temp = nums[i];
            int j;
            for (j=i-1;j>=0;j--){
              if (nums[j]>temp){
                nums[j+1]=nums[j];
              }else {
                break;
              }
            }
            nums[j+1]=temp;
        }
    }
}
