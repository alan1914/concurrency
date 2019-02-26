package com.mmall.concurrency.example.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author stone
 * @des TODO
 * @date 2019/2/26/026 17:18
 **/
@Slf4j
public class ThreadPoolExample3 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for(int i = 0 ; i < 10 ; i++){
            final int index = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    log.info("task : {}",index);
                }
            });
        }

        executorService.shutdown();
    }

}
