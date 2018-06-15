package com.demo.concurrency.example.syncContainer;

import com.demo.concurrency.annoations.NotThreadSafe;
import com.demo.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by Wangpeng on 2018/6/15.
 */
@Slf4j
@NotThreadSafe
public class VectorExample2 {

    // 请求总数
    public static int clientTool = 5000;

    // 同时并发执行的线程数
    public static int threadTool = 200;

    private static Vector<Integer> list = new Vector<>();

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++){
            list.add(i);
        }
        while (true){
            Thread thread = new Thread(){
                public void run(){
                    for (int i = 0; i < list.size(); i++){
                        list.remove(i);
                    }
                }
            };

            Thread thread1 = new Thread(){
                public void run(){
                    for (int i = 0; i < list.size(); i++){
                        list.get(i);
                    }
                }
            };

            thread.start();
            thread1.start();
        }

    }

    private static void update(int k){
        list.add(k);
    }

}
