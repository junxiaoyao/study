package niuke;

import java.util.ArrayList;

/**
 * @description
 * @author: jxy
 * @create: 2019-06-04 09:40
 */
//输入一个矩阵，
// 按照从外向里以顺时针的顺序依次打印出每一个数字
// ，例如，如果输入如下4 X 4矩阵：
// 1 2 3 4
// 5 6 7 8
// 9 10 11 12
// 13 14 15 16
// 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
public class T20 {

  public static void main(String[] args) {
    int[][] nums = {
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15, 16}
    };
    T20 t20 = new T20();
    int[][] ss = t20.cfArray(nums);
    ArrayList<Integer> printMatrix=t20.printMatrix(nums);
    System.out.println();
  }

  public ArrayList<Integer> printMatrix(int[][] matrix) {
    ArrayList<Integer> list = new ArrayList<>();
      printArray(matrix, list);
      int[][]a=cfArray(matrix);
      while (a!=null){
        printArray(a, list);
        a=cfArray(a);
      }
    return list;
  }

  public void printArray(int[][] matrix, ArrayList<Integer> list) {
    int x = 0;
    int y = 0;
    for (; y < matrix[0].length; y++) {
      // System.out.println(matrix[x][y]);
      list.add(matrix[x][y]);
    }
    y--;
    for (x++; x < matrix.length; x++) {
      // System.out.println(matrix[x][y]);
      list.add(matrix[x][y]);
    }
    x--;
    for (y--; y > -1; y--) {
      // System.out.println(matrix[x][y]);
      list.add(matrix[x][y]);
    }
    y++;
    for (x--; x > 0; x--) {
      // System.out.println(matrix[x][y]);
      list.add(matrix[x][y]);
    }
  }

  public int[][] cfArray(int[][] rootArray) {
    if (rootArray.length < 3 || rootArray[0].length < 3) {
      return null;
    }
    int[][] array = new int[rootArray.length - 2][rootArray[0].length - 2];
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
        array[i][j] = rootArray[i + 1][j + 1];
      }
    }
    return array;
  }
}
