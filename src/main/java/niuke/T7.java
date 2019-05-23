package niuke;

//大家都知道斐波那契数列，
// 现在要求输入一个整数n，
// 请你输出斐波那契数列的第n项（从0开始，第0项为0）。
//n<=39
public class T7 {

  public static void main(String[] args) {
    System.out.println(new T7().Fibonacci(6));
  }

  public int Fibonacci(int n) {
    return feibo(n);
  }

  public int feibo(int n) {
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    return feibo(n - 1) + feibo(n - 2);
  }
}
