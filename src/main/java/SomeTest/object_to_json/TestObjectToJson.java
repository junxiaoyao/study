package SomeTest.object_to_json;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Data;

/**
 * @description
 * @author: jxy
 * @create: 2020-01-07 09:21
 */
public class TestObjectToJson {
   final static ObjectMapper OBJECTMAPPER = new ObjectMapper();
  public static void main(String[] args)throws Exception {
    OneObject oneObject=new OneObject();
    oneObject.setNum(6);
    oneObject.setStr("sd");
    Map<String,Object> map=new HashMap<>();
    List list=new ArrayList<>();

    list.add(oneObject);
    map.put("sd",list);
    System.out.println(OBJECTMAPPER.writeValueAsString(map));
  }
}
@Data
class OneObject{
  private int num;
  private String str;
}