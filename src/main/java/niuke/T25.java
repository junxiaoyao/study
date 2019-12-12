package niuke;

import java.util.Collections;
import java.util.Stack;

/**
 * @description 输入参数为字符串型的n维数组， 数组的每一项值为数组 或 int型数字。 请实现一个函数，可以获取列表嵌套列表的最大深度为多少 输入描述: 输入参数为字符串型的 n维数组，列表的每一项值为数组 或
 *              int型数字。数组内的数组， 每一项值，也可以是数组 或 int型数字。 输出描述: int型数字，表示数组嵌套的深度。 示例1 输入 复制 [[1], [2,3,4], [5,[2,3]], [7],
 *              [0,[1,2,3,4],3,5], [1,3], [3,2,4]] 输出 复制 3 说明 n维数组的深度为3
 * @author: jxy
 * @create: 2019-12-12 16:43
 */
public class T25 {

    public static void main(String[] args) {
      System.out.println(getLength("[[1], [2,3,4], [5,[2,3]], [7], [0,[1,2,3,4],3,5], [1,3], [3,2,4]]"));
    }

    public static int getLength(String arrStr) {
        int length = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < arrStr.length(); i++) {
            char ch = arrStr.charAt(i);
            if (ch == '[') {
                stack.push(ch);
                if (stack.size() > length) {
                    length = stack.size();
                }
            } else if (ch == ']') {
                stack.pop();
            }
        }
        return length;
    }
}
