package jvm_study.part9.remote.test;

/**
 * @author jxy
 * @className HotSwapClassLoder
 * @description 为了多次载入执行类的加载器
 * 将difineClass方法开放，仅外部显式调用的时候才会使用到loadByte方法
 * 由虚拟机调用时，仍然按照原有双亲委派规则使用loadClass进行类加载
 * @date 2020/5/11 20:24
 */
public class HotSwapClassLoder extends ClassLoader{
    public HotSwapClassLoder() {
        super(HotSwapClassLoder.class.getClassLoader());
    }
    public Class loadByte(byte[] classByte){
        return defineClass(null,classByte,0,classByte.length);
    }
}
