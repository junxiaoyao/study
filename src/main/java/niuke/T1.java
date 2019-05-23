package niuke;

import java.util.Arrays;

/**
 * 题目描述 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。 请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class T1 {

  public static void main(String[] args) {
    int[][] nums = {
        {1, 4, 10, 12},
        {5, 6, 11, 14},
        {7, 8, 13, 15}
    };
    int num = 12;
    System.out.println(Find(13,nums));
  }

  public static boolean Find(int target, int[][] array) {
    int width = array.length;
    int length = 0;
    if (width > 0) {
      length = array[0].length;
    }
    if (length < 1) {
      return false;
    }
    //数组最后、第一个查找不到，即超出范围
    if (array[width - 1][length - 1] < target || target < array[0][0]) {
      return false;
    }
    int cWidth = width - 1;
    int cLength = 0;
    while (cWidth > -1 && cLength > -1 && cWidth < width && cLength < length) {
      if (array[cWidth][cLength] == target) {
        return true;
      }
      if (array[cWidth][cLength] < target) {
        cLength++;
      }else {
        cWidth--;
      }

    }
    cLength++;
    return false;
  }
}
