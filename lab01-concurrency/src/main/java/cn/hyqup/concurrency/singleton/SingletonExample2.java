package cn.hyqup.concurrency.singleton;

/**
 * Copyright © 2021灼华. All rights reserved.
 *
 * @author create by hyq
 * @version 1.0
 * @date 2021/5/13
 * @description: 懒汉式（需要的时候才去创建）【不推荐的写法】
 */
public class SingletonExample2 {
    //  私有构造函数
    private SingletonExample2() {
    }

    private static SingletonExample2 instance = null;

    /**
     * 统一时间只有一个线程访问,虽然是线程安全的,但不推荐
     * 原因：加锁在方法上容易造成资源浪费
     * @return
     */
    public static synchronized SingletonExample2 getInstance() {
        if (instance == null) {
            instance = new SingletonExample2();
        }
        return instance;
    }
}
