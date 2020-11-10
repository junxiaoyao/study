package java8.stream;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.poi.ss.usermodel.DateUtil;

/**
 * @author : porteryao
 * @description : 描述
 * @date : 2020/10/30 17:38
 */
public class TestStreamApiMain {

    public static void main(String[] args) {
        List<TestStreamEntity> source=new LinkedList<>();
        for (int i=0;i<10;i++){
            int random=(int)(Math.random()*2);
            if (random>0){
                source.add(new TestStreamEntity("user_"+i,"man", new Date().toString()));
            }else {
                source.add(new TestStreamEntity("user_"+i,"woman", new Date().toString()));
            }
        }
        source.stream().filter(r -> r.getSex().equals("man"))
                .collect(Collectors.toList());
        System.out.println();
    }
}
