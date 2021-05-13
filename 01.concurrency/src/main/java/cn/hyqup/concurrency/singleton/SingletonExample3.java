package cn.hyqup.concurrency.singleton;

/**
 * Copyright © 2021灼华. All rights reserved.
 *
 * @author create by hyq
 * @version 1.0
 * @date 2021/5/13
 * @description: 懒汉式（需要的时候才去创建）-【推荐的写法】
 */
public class SingletonExample3 {
    //  私有构造函数
    private SingletonExample3() {
    }
    //    volatile+双重检测机制=》禁止指令重排序
    private volatile static SingletonExample3 instance = null;

    /**
     * 1、双重检测机制
     * 2、同步锁
     * 3、禁止指令重排
     *
     * @return
     */
    public static SingletonExample3 getInstance() {
        if (instance == null) {
            synchronized (SingletonExample3.class) {
                if (instance == null) {
                    instance = new SingletonExample3();
                }
            }
        }
        return instance;
    }
}
