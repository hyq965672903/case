package cn.hyqup.concurrency.singleton;

/**
 * Copyright © 2021灼华. All rights reserved.
 *
 * @author create by hyq
 * @version 1.0
 * @date 2021/5/13
 * @description: 枚举单例（JVM 保证）-【推荐的写法】
 */
public class SingletonExample4 {
    //  私有构造函数
    private SingletonExample4() {
    }

    /**
     * 1、既能保证整个对象初始化一次
     * 2、又能保证在使用的使用的时候才去初始化
     *
     * @return
     */
    public static SingletonExample4 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {
        INSTANCE;
        private SingletonExample4 singleton;

        Singleton() {
            singleton = new SingletonExample4();
        }

        public SingletonExample4 getInstance() {
            return singleton;
        }

    }
}
