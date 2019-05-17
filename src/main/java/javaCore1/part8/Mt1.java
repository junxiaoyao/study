package javaCore1.part8;

import java.io.Serializable;

public class Mt1 {

  public static void main(String[] args) throws Exception{
    //不能创建参数化类型泛型数组
    //Parts<String>[] parts=new Parts<String>[10];
    Parts<String>[] parts=(Parts<String>[])new Parts<?>[10];
    Parts<Mt1> parts1=new Parts<>();
    Mt1 mt1=parts1.createT(Mt1.class);
    System.out.println(mt1.toString());
  }

  //extends 非implements ，T可能为借口或者类，切extends接近子类概念
  public static <T extends Cloneable & Serializable> void show() {
    ;
  }
}
