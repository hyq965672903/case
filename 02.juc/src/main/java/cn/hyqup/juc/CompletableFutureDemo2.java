package cn.hyqup.juc;

import java.util.concurrent.*;

/**
 * Copyright © 2022 灼华. All rights reserved.
 *
 * @author create by hyq
 * @version 0.1
 * @date 2022/6/18
 * @description:
 */
public class CompletableFutureDemo2 {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 10, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(20), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        }).thenApply(fn -> {
            return fn + 2;
        }).whenComplete((v, e) -> {
            System.out.println("结果" + v);
        }).exceptionally(e -> {
            e.printStackTrace();
            return null;
        });
        threadPoolExecutor.shutdown();

        System.out.println("main 结束");
        // 前面是守护线程,保证前面线程结果执行完
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
