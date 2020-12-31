package me.tairy.leetcode.gc;

/**
 * package: me.tairy.leetcode.gc
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2020-12-30 21:24
 * <p>
 * -Xms1024m -Xmx1024m -Xmn512m -XX:+PrintGCDetails
 */
public class TestGCRoots01 {

    private int _10MB = 10 * 1024 * 1024;

    private byte[] memory = new byte[8 * _10MB];

    public static void main(String[] args) {
        method01();
        System.out.println("返回 main 方法");
        System.gc();
        System.out.println("第二次 GC 完成");
    }

    private static void method01() {
        TestGCRoots01 testGCRoots01 = new TestGCRoots01();
        System.gc();
        System.out.println("第一次 GC 完成");
    }
}
