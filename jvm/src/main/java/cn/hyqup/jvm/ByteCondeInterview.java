package cn.hyqup.jvm;

import org.junit.Test;

/**
 * Copyright © 2022 灼华. All rights reserved.
 *
 * @author create by hyq
 * @version 0.1
 * @date 2022/9/18
 * @description:
 */
public class ByteCondeInterview {

    /**
     * 包装类对象的缓存问题
     * Byte         -128-127
     * Short        -128-127
     * Integer      -128-127
     * Long         -128-127
     * Float        没有
     * Double       没有
     * Character    0-127
     * Boolean      true/false
     */
    @Test
    public void test1() {
        Integer i1 = 128;
        Integer i2 = 128;

        System.out.println(i1 == i2); //false
    }


    @Test
    public void test2() {
        String str1 = new String("hello") + new String("world");
        String str2 = "helloworld";

        System.out.println(str1 == str2); //false
    }


    @Test
    public void test3() {
        String str1 = new String("hello") + new String("world");
        str1.intern();
        String str2 = "helloworld";
        System.out.println(str1 == str2); //true
    }
}
