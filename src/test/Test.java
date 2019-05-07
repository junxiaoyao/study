public class Test {
    public static void main(String[] args) {
//        int i=0;
//        int s=++++++(i++)++(++i)++++i++i++213;
        new Test().test();
    }
    public void test(){
        int m=100;
        for(int i=2;i<Math.sqrt(m);i++){
            for(int j=2*i;j<m;j+=i){
                myprint(j);
            }
        }
    }
    public void myprint(int i){
        System.out.println("I:"+i);
    }
}
