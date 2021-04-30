//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//[1,5,10,10,5,1]
//] 
// Related Topics 数组 
// 👍 487 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：杨辉三角
public class P118PascalsTriangle {

    public static void main(String[] args) {
        Solution solution = new P118PascalsTriangle().new Solution();
        // TO TEST
        solution.generate(5);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> onePart = new ArrayList<>(1);
            onePart.add(1);
            result.add(onePart);
            for (int i = 1; i < numRows; i++) {
                List<Integer> part = new ArrayList<>();
                part.add(1);
                for (int j = 1; j < i+1; j++) {
                    int leftIndex = j - 1;
                    int leftNum = result.get(i - 1).get(leftIndex);
                    int rightNum = 0;
                    if (result.get(i - 1).size() > j) {
                        rightNum = result.get(i - 1).get(j);
                    }
                    part.add( leftNum + rightNum);
                }
                result.add(part);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
