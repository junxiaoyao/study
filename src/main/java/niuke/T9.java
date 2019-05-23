package niuke;

//一只青蛙一次可以跳上1级台阶，
// 也可以跳上2级……
// 它也可以跳上n级。
// 求该青蛙跳上一个n级的台阶总共有多少种跳法。
public class T9 {

  public static void main(String[] args) {
    System.out.println(new T9().JumpFloor(5));
  }

  public int JumpFloor(int target) {
    int sum = 0;
    if (target < 2) {
      return 1;
    }
    if (target == 2) {
      return 2;
    }
    for (int i = 1; i <= target; i++) {
      sum += JumpFloor(target - i);
    }
    return sum;
  }
}

