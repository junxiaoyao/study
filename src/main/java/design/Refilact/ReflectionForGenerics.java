package design.Refilact;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

//用过反射获取泛型信息
public class ReflectionForGenerics {
    public void test01(Map<String,Object> map,List<Object> users){
        System.out.println("test01");
    }

    public Map<Integer,Object> test02(){
        System.out.println("test02");
        return null;
    }

    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("design.Refilact.ReflectionForGenerics");
            //获得指定方法参数泛型信息
            Method method = clazz.getMethod("test01", Map.class,List.class);
            //获取泛型参数
            Type[] types = method.getGenericParameterTypes();
            for (Type type : types) {
                System.out.println("#"+type);
                if(type instanceof ParameterizedType){
                    Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
                    for (Type type2 : actualTypeArguments) {
                        System.out.println("泛型参数类型："+type2);
                    }
                }
            }

            System.out.println("--------------------------------------------------------------");
            Method method2 = clazz.getMethod("test02", null);
            //获取返回值泛型信息
            Type returnType = method2.getGenericReturnType();
            System.out.println("#"+returnType);
            if(returnType instanceof ParameterizedType){
                Type[] typeArguments = ((ParameterizedType) returnType).getActualTypeArguments();
                for (Type type : typeArguments) {
                    System.out.println("返回值泛型类型："+type);
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}