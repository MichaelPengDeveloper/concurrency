package com.demo.concurrency.example.syncContainer;

import com.demo.concurrency.annoations.NotThreadSafe;
import com.demo.concurrency.annoations.ThreadSafe;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by Wangpeng on 2018/6/15.
 */
@Slf4j
@ThreadSafe
public class VectorExample1 {

    // 请求总数
    public static int clientTool = 5000;

    // 同时并发执行的线程数
    public static int threadTool = 200;

    private static Vector<Integer> list = new Vector<>();

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTool);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTool);

        for (int i = 0; i < clientTool; i++){
            final int k = i;
            executorService.execute(() ->{
                try {
                    semaphore.acquire();
                    update(k);
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("size {}", list.size());
    }

    private static void update(int k){
        list.add(k);
    }

}
