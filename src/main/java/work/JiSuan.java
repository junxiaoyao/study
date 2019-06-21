package work;

/**
 * @description
 * @author: jxy
 * @create: 2019-06-13 10:52
 */
public class JiSuan {
static int s;
  public static void main(String[] args) {
    System.out.println(s);
    int jishu=500;
    int fs=110;
    System.out.println("jl:"+jl(jishu,fs));
    System.out.println("kj:"+kj(jishu,fs));
  }

  //奖励
  public static double jl(int jishu,int fs){
    return jishu*((fs-100)/0.2)/100.0;
  }
  //kj
  public static double kj(int jishu,int fs){
    return jishu*((100-fs)/0.2)/100.0;
  }
}
