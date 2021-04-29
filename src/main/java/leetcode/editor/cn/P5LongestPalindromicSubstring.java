//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3468 👎 0


package leetcode.editor.cn;

//Java：最长回文子串
public class P5LongestPalindromicSubstring {

    public static void main(String[] args) {
        Solution solution = new P5LongestPalindromicSubstring().new Solution();
        // TO TEST
        solution.longestPalindrome("babad");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String longestPalindrome(String s) {
            int length = s.length();
            if (length < 2) {
                return s;
            }
            boolean[][] booleans = new boolean[s.length()][s.length()];
            //将对角线设置为true

            for (int i = 0; i < length; i++) {
                booleans[i][i] = true;
            }
            int index = 0;
            int resultLength = 1;
            //dp[i][j]//"cbbd"
            for (int i = 1; i < length; i++) {
                for (int j = 0; j < i; j++) {
                    if (s.charAt(i) != s.charAt(j)) {
                        booleans[j][i] = false;
                    } else {
                        //坐标线上或者间隔小于2的时候是回文
                        int xL = Math.abs(j - i);
                        if (xL < 2) {
                            booleans[j][i] = true;
                        } else {
                            booleans[j][i] = booleans[j + 1][i - 1];
                        }
                        if (booleans[j][i] == true) {
                            if ((xL+1) > resultLength) {
                                resultLength = xL+1;
                                index = j;
                            }
                        }
                    }

                }

            }
            String s1 = s.substring(index,index+resultLength);
            return s1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
