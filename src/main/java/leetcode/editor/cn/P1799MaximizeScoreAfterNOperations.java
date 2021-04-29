//给你 nums ，它是一个大小为 2 * n 的正整数数组。你必须对这个数组执行 n 次操作。 
//
// 在第 i 次操作时（操作编号从 1 开始），你需要： 
//
// 
// 选择两个元素 x 和 y 。 
// 获得分数 i * gcd(x, y) 。 
// 将 x 和 y 从 nums 中删除。 
// 
//
// 请你返回 n 次操作后你能获得的分数和最大为多少。 
//
// 函数 gcd(x, y) 是 x 和 y 的最大公约数。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,2]
//输出：1
//解释：最优操作是：
//(1 * gcd(1, 2)) = 1
// 
//
// 示例 2： 
//
// 输入：nums = [3,4,6,8]
//输出：11
//解释：最优操作是：
//(1 * gcd(3, 6)) + (2 * gcd(4, 8)) = 3 + 8 = 11
// 
//
// 示例 3： 
//
// 输入：nums = [1,2,3,4,5,6]
//输出：14
//解释：最优操作是：
//(1 * gcd(1, 5)) + (2 * gcd(2, 4)) + (3 * gcd(3, 6)) = 1 + 4 + 9 = 14
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 7 
// nums.length == 2 * n 
// 1 <= nums[i] <= 106 
// 
// Related Topics 递归 动态规划 回溯算法 
// 👍 10 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：N 次操作后的最大分数和
public class P1799MaximizeScoreAfterNOperations {

    public static void main(String[] args) {
        Solution solution = new P1799MaximizeScoreAfterNOperations().new Solution();
        // TO TEST
        int[] nums = {697035, 181412, 384958, 575458};
        int[] nums2 = {415, 230, 471, 705, 902, 87};
        int[] nums3 = {3, 4, 6, 8};
        solution.maxScoreV2(nums2);
        // System.out.println(solution.maxScore(nums2));
        // System.out.println(solution.maxScore(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 推测必须将最大公约数对的放在最后 1.先排序 2.倒着分组，从最后搜索，求最后一个数和某个数的最大公约数
         */
        public int maxScore(int[] nums) {
            Arrays.sort(nums);
            int sum = 0;
            //一组不做操作
            if (nums.length < 4) {
                return gcd(nums[0], nums[1]);
            }
            List<Integer> integerList = new ArrayList<>();
            while (nums.length > 0) {

                int[] ints = searchMax(nums, nums.length - 2, 1, nums.length - 2, nums.length - 1);
                //用于排除下标不是最后一个元素参与的最大约数操作
                for (int i = nums.length - 2; i > 0; i--) {
                    int[] intTemp = searchMax(nums, i - 1, 1, i - 1, i);
                    int intTempGcd = intTemp[0];
                    if (intTempGcd >= ints[0]) {
                        ints = intTemp;
                    }
                }
                int gcd = ints[0];
                integerList.add(gcd);
                //移位操作
                int firstIndex = ints[1];
                int secondIndex = ints[2];
                int[] numsLeft = Arrays.copyOfRange(nums, 0, firstIndex);
                int[] numsCenter = Arrays.copyOfRange(nums, firstIndex + 1, secondIndex);
                int[] numsRight = Arrays.copyOfRange(nums, secondIndex + 1, nums.length);
                int[] target = new int[numsLeft.length + numsCenter.length + numsRight.length];
                System.arraycopy(numsLeft, 0, target, 0, numsLeft.length);
                System.arraycopy(numsCenter, 0, target, numsLeft.length, numsCenter.length);
                System.arraycopy(numsRight, 0, target, numsLeft.length + numsCenter.length,
                        numsRight.length);
                nums = target;
            }
            integerList.sort((o1, o2) -> o2 - o1);
            for (int i = 0; i < integerList.size(); i++) {
                sum += (integerList.size() - i) * integerList.get(i);
            }
            return sum;
        }

        //倒着搜索,找到比当前gcd小的直接退出，说明倒排已寻找至最大数字，
        //改进版。搜索下标为target的最大公约数组
        //返回gcd和当前下标方便移除
        public int[] searchMax(int[] nums, int indexNow, int nowGcd, int selectIndex, int target) {
            //如果搜到到下标0，则直接返回当前组合的最大公约数
            if (indexNow == 0) {
                //如果此时相等，将当前选择
                int tempGcd = gcd(nums[target], nums[0]);
                if (tempGcd >= nowGcd) {
                    return new int[]{tempGcd, 0, target};
                }
                return new int[]{nowGcd, selectIndex, target};
            }
            int tempGcd = gcd(nums[target], nums[indexNow]);
            //如果当前gcd大选种当前
            if (tempGcd >= nowGcd) {
                return searchMax(nums, indexNow - 1, tempGcd, indexNow, target);
            } else {
                return searchMax(nums, indexNow - 1, nowGcd, selectIndex, target);
            }
        }

        public int gcd(int one, int two) {
            if (two == 0) {
                return one;
            }
            return gcd(two, one % two);
        }


        public int maxScoreV2(int[] nums) {
            int sum = 0;
            int[][] gcds = new int[nums.length][nums.length];
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums.length; j++) {
                    if (i != j) {
                        int temp = gcd(nums[i], nums[j]);
                        gcds[i][j] = temp;
                    } else {
                        gcds[i][j] = -1;
                    }
                }
            }
            int length = nums.length;
            while (length > 0) {
                int selectMax = selectMax(gcds);
                length = length / 2;
                sum += length * selectMax;
            }
//            int selectMax1 = selectMax(gcds);
//            int selectMax2 = selectMax(gcds);
            return sum;
        }

        public int selectMax(int[][] nums) {
            int max = nums[1][0];
            int maxRow = 1;
            int maxCol = 0;
            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i][j] > max) {
                        if (test(nums, i, j)) {
                            max = nums[i][j];
                            maxRow = i;
                            maxCol = j;
                        }
                    }
                }
            }
            nums[maxRow][maxCol] = 0;
            test2(nums,maxRow,maxCol);
            return max;
        }

        //将已选择的行列置位0
        public void test2(int[][] nums, int rowIndex, int colIndex) {
            for (int i = 1; i < nums.length; i++) {
                nums[i][colIndex] = 0;
            }
            //判断行是有被使用
//            for (int i = 0; i < nums.length; i++) {
//                nums[rowIndex][i] = 0;
//            }
        }

        //判断选择行列是否有已被使用的数据
        public boolean test(int[][] nums, int rowIndex, int colIndex) {
            //判断列是有被使用
           for (int i = 1; i < nums.length; i++) {
                if (nums[i][colIndex] == 0) {
                    return false;
                }
            }
//            //判断行是有被使用
            for (int i = 0; i < rowIndex; i++) {
                if (nums[rowIndex][i] == 0) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
