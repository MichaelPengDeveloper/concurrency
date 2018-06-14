package com.demo.concurrency.example.singleton;

import com.demo.concurrency.annoations.NotThreadSafe;

/**
 * 懒汉式 -- 双重同步锁 会有指令重排的问题
 * 单例实例在第一次使用的时候创建
 * Created by Wangpeng on 2018/6/13.
 */
@NotThreadSafe
public class SingletonExample4 {

    // 私有构造函数
    private SingletonExample4(){

    }

    // 单利对象
    private static SingletonExample4 singletonExample1 = null;

    // 静态工厂方法
    public static SingletonExample4 getInstance(){
        if (singletonExample1 == null){
            synchronized (SingletonExample4.class){ //同步锁
                if (singletonExample1 == null){
                    singletonExample1 = new SingletonExample4();
                }
            }
        }
        return singletonExample1;
    }

}
