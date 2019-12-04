package niuke;

import java.util.Arrays;

/**
 * @description 装满背包可行方案算法
 * @author: jxy
 * @create: 2019-12-03 15:16
 */
public class TestPackage {
    static int count=0;
    public static void main(String[] args) {
//        int[] nums = new int[3];
//        int[] price = new int[] {2, 3, 4};
//        int space = 9;
        int[] nums = new int[5];
        int[] price = new int[] {9,2,6,3,5};
      //  Arrays.sort(price);
        int space = 200;
        System.out.println("数组");
        System.out.println(Arrays.toString(price));
        System.out.println("price结果数组");
        buyFor2(nums, price, space, 0);
        System.out.println(count);

    }

    // 可重复购买
    public static void buyFor2(int[] nums, int[] price, int space, int start) {
        if (space == 0) {
            System.out.println(Arrays.toString(nums));
            count++;
            return;
        }
        if (start >price.length - 1) {
            return;
        }
//        if (space < price[0]) {
//            return;
//        }
        if (space < price[start]) {
            buyFor2(nums, price, space, ++start);
            return;
        }
        int[] nums2 = Arrays.copyOf(nums, nums.length);
        nums2[start] += 1;
        //购买当前产品
        buyFor2(nums2, price, space - price[start], start);
        //不购买
        buyFor2(nums, price, space, ++start);
    }

    // 不重复购买
    // public static void buyFor(int[] nums, int[] price, int space, int start) {
    // if (space == 0) {
    // System.out.println(Arrays.toString(nums));
    // return;
    // }
    // if (start >= price.length - 1) {
    // return;
    // }
    // if (space < 2) {
    // return;
    // }
    // if (space < price[start]) {
    // return;
    // }
    // int[] nums2 = Arrays.copyOf(nums, nums.length);
    // nums2[start] += 1;
    // buyFor(nums2, price, space - price[start], ++start);
    // buyFor(nums, price, space, ++start);
    //
    // }
}
