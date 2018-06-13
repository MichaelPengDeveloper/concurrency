package com.demo.concurrency.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Wangpeng on 2018/6/13.
 */
@Slf4j
public class SynchronizedExample1 {

    // 修饰一个代码块
    public void test1(int k){
        synchronized (this){
            for (int i = 0; i < 10; i++){
                log.info("test - {} - {}", i, k);
            }
        }
    }

    // 修饰一个方法
    public synchronized void test2(int k){
        for (int i = 0; i < 10; i++){
            log.info("test - {}- {}", i, k);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample1 synch1 = new SynchronizedExample1();
        SynchronizedExample1 synch2 = new SynchronizedExample1();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() ->{
            synch1.test2(1);
        });
        executorService.execute(() ->{
            synch2.test2(2);
        });

    }

}
