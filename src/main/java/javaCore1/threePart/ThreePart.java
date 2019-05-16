package javaCore1.threePart;

import java.util.Arrays;

public class ThreePart {

 static int q;

  public static void main(String[] args) {
    System.out.println(ThreePart.q);
    ThreePart threePart = new ThreePart();
    System.out.println(threePart);
    threePart.gt(threePart);
    System.out.println(threePart);
    int s = 0B0_1110;
    int sq = 1_000_000;
    //int q;
    System.out.println(1.0/0);
    System.out.println(threePart.q);
    System.out.println('\u2122');
    int [] nums={5,6,1,2,6,1,4};
    Arrays.sort(nums);
    System.out.println(nums[0]);
  }
  public void gt(ThreePart threePart){
    threePart=new ThreePart();
  }
}
