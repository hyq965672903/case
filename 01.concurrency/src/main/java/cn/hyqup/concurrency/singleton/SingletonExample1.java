package cn.hyqup.concurrency.singleton;

/**
 * Copyright © 2021灼华. All rights reserved.
 *
 * @author create by hyq
 * @version 1.0
 * @date 2021/5/13
 * @description: 饿汉式（类加载的时候就创建好）
 */
public class SingletonExample1 {
    //   私有构造函数
    private SingletonExample1() {
    }

    private static SingletonExample1 instance = new SingletonExample1();

    public static SingletonExample1 getInstance() {
        return instance;
    }
}
