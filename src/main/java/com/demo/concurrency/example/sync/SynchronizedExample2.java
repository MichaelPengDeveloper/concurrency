package com.demo.concurrency.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Wangpeng on 2018/6/13.
 */
@Slf4j
public class SynchronizedExample2 {

    // 修饰一个类
    public static void test1(int k){
        synchronized (SynchronizedExample2.class){
            for (int i = 0; i < 10; i++){
                log.info("test - {} - {}", i, k);
            }
        }
    }

    // 修饰一个静态方法
    public static synchronized void test2(int k){
        for (int i = 0; i < 10; i++){
            log.info("test - {}- {}", i, k);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample2 synch1 = new SynchronizedExample2();
        SynchronizedExample2 synch2 = new SynchronizedExample2();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() ->{
            synch1.test1(1);
        });
        executorService.execute(() ->{
            synch2.test1(2);
        });

    }

}
