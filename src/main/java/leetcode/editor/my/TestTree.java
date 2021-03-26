package leetcode.editor.my;

import java.util.ArrayList;
import java.util.List;

public class TestTree {

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 2, 3};
        test(nums, 0, 0, 5, new ArrayList<Integer>());
    }

    public static void test(int[] nums, int index, int sum, int target, List<Integer> selects) {
        if (index >= nums.length) {
            System.out.println("数组遍历完毕");
            return;
        }
        int temp = nums[index] + sum;
        selects.add(nums[index]);
        if (temp == target) {
            System.out.println(selects.toString());
            return;
        }
        if (temp > target) {
            return;
        }

        //此时说明还不够那么大，选择当前节点子节点 左：2*index+1，右： 2*index+2
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        test(nums,left,temp,target,new ArrayList<>(selects));
        test(nums,right,temp,target,new ArrayList<>(selects));
    }
}
