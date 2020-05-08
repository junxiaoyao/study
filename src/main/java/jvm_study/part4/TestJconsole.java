package jvm_study.part4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jxy
 * @className TestJconsole
 * @description 描述
 * @date 2020/4/23 22:04
 */
public class TestJconsole {
    static class OOMObject{
        public byte[] placeholder=new byte[64*1024];
    }
    public static void fillHeap(int num)throws Exception{
        List<OOMObject> list= new LinkedList<>();
        for (int i=0;i<num;i++){
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
        System.in.read();
    }

    public static void main(String[] args) throws Exception{
        fillHeap(1000);
    }
}
