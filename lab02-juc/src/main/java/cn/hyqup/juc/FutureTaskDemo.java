package cn.hyqup.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Copyright © 2022 灼华. All rights reserved.
 *
 * @author create by hyq
 * @version 0.1
 * @date 2022/6/18
 * @description:
 */
class CookDinner implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        for (int i = 0; i < 50; i++) {
            System.out.println("正在做第" + i + "份饭");
        }
        return 50;
    }
}

public class FutureTaskDemo {


    public static void main(String[] args) {
        CookDinner cookDinner = new CookDinner();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(cookDinner);
        Thread thread = new Thread(futureTask);
        thread.setName("thread1");
        thread.start();

        try {
            Integer integer = futureTask.get();
            System.out.println("总共做了"+integer+"份饭");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}
