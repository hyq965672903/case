package cn.hyqup.juc;

import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

/**
 * Copyright © 2022 灼华. All rights reserved.
 *
 * @author create by hyq
 * @version 0.1
 * @date 2022/6/22
 * @description:
 */
public class LongAdderDemo {
    public static void main(String[] args) {
        LongAdder longAdder = new LongAdder();

        longAdder.increment();
        longAdder.increment();
        longAdder.increment();

        System.out.println(longAdder.longValue());

        LongAccumulator longAccumulator = new LongAccumulator((x, y) -> x * y, 2);

        longAccumulator.accumulate(1);
        longAccumulator.accumulate(2);
        longAccumulator.accumulate(3);

        System.out.println(longAccumulator.longValue());
    }
}
