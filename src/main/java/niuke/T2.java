package niuke;

///**
// * 题目描述 请实现一个函数，
// * 将一个字符串中的每个空格替换成“%20”。
// * 例如，当字符串为We Are Happy.
// * 则经过替换之后的字符串为We%20Are%20Happy。
// */
public class T2 {

  public static void main(String[] args) {
    StringBuffer stringBuffer = new StringBuffer("We Are Happy");
    replaceSpace(stringBuffer);
  }

  public static String replaceSpace(StringBuffer str) {
    String s=str.toString().replaceAll(" ","%20");
    return s;
  }
}
