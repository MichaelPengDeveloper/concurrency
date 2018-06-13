package com.demo.concurrency.example.atomic;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * Created by Wangpeng on 2018/6/13.
 */
@Slf4j
public class AtomicExample5 {

    private static AtomicIntegerFieldUpdater<AtomicExample5> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class, "count");

    @Getter
    private volatile int count = 100;

    private static AtomicExample5 atomicExample5 = new AtomicExample5();

    public static void main(String[] args) {
        if (updater.compareAndSet(atomicExample5, 100, 120)){
            log.info("update success1:{}", atomicExample5.getCount());
        }
        if (updater.compareAndSet(atomicExample5, 100, 120)){
            log.info("update success2:{}", atomicExample5.getCount());
        }else {
            log.info("update success:{}", atomicExample5.getCount());
        }
    }

}

