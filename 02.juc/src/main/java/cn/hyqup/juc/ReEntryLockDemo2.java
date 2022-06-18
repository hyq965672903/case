package cn.hyqup.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Copyright © 2022 灼华. All rights reserved.
 *
 * @author create by hyq
 * @version 0.1
 * @date 2022/6/18
 * @description: 可重复锁Demo
 */


public class ReEntryLockDemo2 {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("外部");
                lock.lock();
                try {
                    System.out.println("内部");
                } finally {
                    lock.unlock();
                }
            } finally {
                lock.unlock();
            }
        }).start();

    }
}
