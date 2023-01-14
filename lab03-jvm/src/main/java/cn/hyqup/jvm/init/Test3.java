package cn.hyqup.jvm.init;

/**
 * Copyright © 2022 灼华. All rights reserved.
 *
 * @author create by hyq
 * @version 0.1
 * @date 2022/9/23
 * @description:
 */
public class Test3 {
    public Test3 test3 = new Test3("张三");
    static int K = method1(0);
    static int I = 10;

    {
        System.out.println("初始化块");
    }

    static {
        System.out.println("Order类的初始化");
    }

    public Test3(String str) {
        System.out.println(str);
    }

    public static int method1(int k) {
        return ++k;
    }

    public static void main(String[] args) {

    }
}
