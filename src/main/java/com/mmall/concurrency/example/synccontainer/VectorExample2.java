package com.mmall.concurrency.example.synccontainer;

import com.mmall.concurrency.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Vector;

/**
 * @author stone
 * @des TODO
 * @date 2019/2/25/025 17:23
 **/
@Slf4j
@NotThreadSafe
public class VectorExample2 {
    // 请求总数
    private static int clientTotal = 5000;

    // 同时并发执行的线程总数
    private static int threadTotal = 200;

    private static Vector<Integer> vector = new Vector<>();


    public static void main(String[] args) throws InterruptedException {
        while (true){

            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }

            Thread thread1 = new Thread(() -> {

                for (int i = 0; i < vector.size(); i++) {
                    vector.remove(i);
                }
            });

            Thread thread2 = new Thread(() -> {
                for (int i = 0; i < vector.size(); i++) {
                    vector.get(i);
                }
            });

            thread1.start();
            thread2.start();
        }
    }

}
