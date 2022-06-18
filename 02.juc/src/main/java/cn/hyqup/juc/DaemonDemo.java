package cn.hyqup.juc;

/**
 * Copyright © 2022 灼华. All rights reserved.
 *
 * @author create by hyq
 * @version 0.1
 * @date 2022/6/18
 * @description:
 */
public class DaemonDemo {
    public static void main(String[] args) {
        new  Thread(()->{
            System.out.println("哈哈哈");
        }).start();
    }

}
