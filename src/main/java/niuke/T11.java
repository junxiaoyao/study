package niuke;

//输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
public class T11 {

  public int NumberOf1(int n) {
    int sum=0;
    String string = Integer.toBinaryString(n);
    for (int i=0;i<string.length();i++)
      if (string.charAt(i)=='1')
        sum++;
   return sum;
  }
}
