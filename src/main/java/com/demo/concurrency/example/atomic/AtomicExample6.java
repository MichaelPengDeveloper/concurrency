package com.demo.concurrency.example.atomic;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongArray;

/**
 * Created by Wangpeng on 2018/6/13.
 */
@Slf4j
public class AtomicExample6 {

    private static AtomicBoolean isHappened = new AtomicBoolean(false);

    // 请求总数
    public static int clientTool = 5000;

    // 同时并发执行的线程数
    public static int threadTool = 200;

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTool);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTool);

        for (int i = 0; i < clientTool; i++){
            executorService.execute(() ->{
                try {
                    semaphore.acquire();
                    test();
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception", e);
                }
                countDownLatch.countDown();
            });
        }
        executorService.shutdown();
        log.info("count：{}", isHappened);

    }

    private static void test(){
        if (isHappened.compareAndSet(false, true)){
            log.info("success");
        }
    }

}

