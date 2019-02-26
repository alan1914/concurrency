package com.mmall.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author stone
 * @des TODO
 * @date 2019/2/26/026 15:38
 **/
@Slf4j
public class FutureExample {


    static class MyCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            log.info("do something in callable ");
            Thread.sleep(5000);
            return "Done";
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ExecutorService exec = Executors.newCachedThreadPool();
        Future<String> future = exec.submit(new MyCallable());
        log.info("do something in main");
        Thread.sleep(1000);
        try {
            String result = future.get();
            log.info("result: {}", result);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }


}
