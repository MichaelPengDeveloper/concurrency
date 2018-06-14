package com.demo.concurrency.example.singleton;

import com.demo.concurrency.annoations.ThreadSafe;

/**
 * 懒汉式 -- 双重同步锁 不有指令重排的问题 volatile
 * 单例实例在第一次使用的时候创建
 * Created by Wangpeng on 2018/6/13.
 */
@ThreadSafe
public class SingletonExample5 {

    // 私有构造函数
    private SingletonExample5(){

    }

    // 单利对象
    private volatile static SingletonExample5 singletonExample1 = null;

    // 静态工厂方法
    public static SingletonExample5 getInstance(){
        if (singletonExample1 == null){
            synchronized (SingletonExample5.class){ //同步锁
                if (singletonExample1 == null){
                    singletonExample1 = new SingletonExample5();
                }
            }
        }
        return singletonExample1;
    }

}
