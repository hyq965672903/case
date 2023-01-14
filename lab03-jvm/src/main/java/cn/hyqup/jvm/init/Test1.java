package cn.hyqup.jvm.init;

import java.io.Serializable;

/**
 * Copyright © 2022 灼华. All rights reserved.
 *
 * @author create by hyq
 * @version 0.1
 * @date 2022/9/22
 * @description:
 */
public class Test1 implements Serializable {
    static final int I = 10;


    static {
        System.out.println("Order类的初始化");
    }

    public Test1() {
        System.out.println("构造函数");
    }
}
