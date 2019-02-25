package com.mmall.concurrency.example.synccontainer;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.mmall.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author stone
 * @des TODO
 * @date 2019/2/25/025 17:23
 **/
@Slf4j
@ThreadSafe
public class CollectionsExample1 {
    // 请求总数
    private static int clientTotal = 5000;

    // 同时并发执行的线程总数
    private static int threadTotal = 200;

    private static Set<Integer> set = Collections.synchronizedSet(Sets.newHashSet());

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            final int count = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    update(count);
                    semaphore.release();
                } catch (InterruptedException e) {
                    log.error("exception", e);

                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("size:{}",set.size());
    }

    private static void update(int i) {
        set.add(i);
    }

}
