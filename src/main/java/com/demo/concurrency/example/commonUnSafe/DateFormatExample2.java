package com.demo.concurrency.example.commonUnSafe;

import com.demo.concurrency.annoations.NotThreadSafe;
import com.demo.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by Wangpeng on 2018/6/15.
 */
@Slf4j
@ThreadSafe
public class DateFormatExample2 {

    // 请求总数
    public static int clientTool = 5000;

    // 同时并发执行的线程数
    public static int threadTool = 200;

    private static DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyyMMdd");

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
    }

    private static void update(int k){
        log.info("{} {}", k, DateTime.parse("20170208", dateTimeFormatter).toDate());

    }

}
