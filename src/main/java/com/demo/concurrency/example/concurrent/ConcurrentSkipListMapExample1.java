package com.demo.concurrency.example.concurrent;

import com.demo.concurrency.annoations.NotThreadSafe;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by Wangpeng on 2018/6/15.
 */
@Slf4j
@NotThreadSafe
public class ConcurrentSkipListMapExample1 {

    // 请求总数
    public static int clientTool = 5000;

    // 同时并发执行的线程数
    public static int threadTool = 200;

    private static Map<Integer, Integer> map = new ConcurrentSkipListMap<>();

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
        log.info("size {}", map.size());
    }

    private static void update(int k){
        map.put(k, k);
    }

}
