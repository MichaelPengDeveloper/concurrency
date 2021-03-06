package com.demo.concurrency.example.singleton;

import com.demo.concurrency.annoations.NotThreadSafe;

/**
 * 懒汉式
 * 单例实例在第一次使用的时候创建
 * Created by Wangpeng on 2018/6/13.
 */
@NotThreadSafe
public class SingletonExample1 {

    // 私有构造函数
    private SingletonExample1(){

    }

    // 单利对象
    private static SingletonExample1 singletonExample1 = null;

    // 静态工厂方法
    public static SingletonExample1 getInstance(){
        if (singletonExample1 == null){
            singletonExample1 = new SingletonExample1();
        }
        return singletonExample1;
    }

}
