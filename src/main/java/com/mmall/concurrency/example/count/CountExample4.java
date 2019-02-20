package com.mmall.concurrency.example.count;

import com.mmall.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author stone
 * @des synchronized
 * @date 2019/2/19/019 11:53
 **/
@Slf4j
@ThreadSafe
public class CountExample4 {

    // 请求总数
    private static int clientTotal = 10000;

    // 同时并发执行的线程总数
    private static int threadTotal = 200;

    public static volatile int count = 0;

    private static void add() {
        count++;
        // 1.count
        // 2.+1
        // 3.count
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    log.error("exception",e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("count {}", count);
    }

}
