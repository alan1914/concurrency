package com.mmall.concurrency.example.atomic;

import com.mmall.concurrency.annotations.NotThreadSafe;

/**
 * Volatile 原子性 测试 结果 不具有原子性
 * @author stone
 **/
@NotThreadSafe
public class VolatileTest {
    private static volatile long _longVal = 0;

    public static void add(){
        _longVal++;
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            long val = 0;
            while (val < 10000000L) {
                add();
                val++;
            }
        });

        Thread t2 = new Thread(() -> {
            long val = 0;
            while (val < 10000000L) {
                add();
                val++;
            }
        });
        t1.start();
        t2.start();

        while (t1.isAlive() || t2.isAlive()) {
        }

        System.out.println("final val is: " + _longVal);
    }
}
