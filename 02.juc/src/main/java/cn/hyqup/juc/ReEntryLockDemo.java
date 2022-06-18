package cn.hyqup.juc;

/**
 * Copyright © 2022 灼华. All rights reserved.
 *
 * @author create by hyq
 * @version 0.1
 * @date 2022/6/18
 * @description: 可重复锁Demo
 */
class WashClothes {

    /**
     * 放水
     */
    public static synchronized void water() {
        System.out.println("放水");
        wash();
    }

    /**
     * 洗衣服
     */
    public static synchronized void wash() {
        System.out.println("洗衣服");
    }
}

public class ReEntryLockDemo {
    public static void main(String[] args) {
        WashClothes washClothes = new WashClothes();
        new Thread(() -> {
            washClothes.water();
        }).start();

    }
}
