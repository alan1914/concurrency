package com.mmall.concurrency.example.atomic;

import com.mmall.concurrency.annotations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author stone
 * @des AtomicReferenceFieldUpdater
 * @date 2019/2/19/019 11:53
 **/
@Slf4j
@ThreadSafe
public class AtomicExample6 {

    private static AtomicBoolean isHappened = new AtomicBoolean(true);

    // 请求总数
    private static int clientTotal = 5000;

    // 线程总数
    private static int threadTotal = 200;

    private static void test() {
        if (isHappened.compareAndSet(true, false)) {
            log.info("isHappened is execute,and the value is :{}", isHappened);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(threadTotal);
        CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        executorService.execute(() -> {
            try {
                semaphore.acquire();
                test();
                semaphore.release();
            } catch (InterruptedException e) {
                log.error("exception:{}", e);
            }
            countDownLatch.countDown();
        });
        countDownLatch.await();
        executorService.shutdown();
    }


}
