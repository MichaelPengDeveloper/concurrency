package com.demo.concurrency.example.singleton;

import com.demo.concurrency.annoations.NotThreadSafe;
import com.demo.concurrency.annoations.ThreadSafe;

/**
 * 饿汉式
 * 单例实例在类装载的时候创建
 * Created by Wangpeng on 2018/6/13.
 */
@ThreadSafe
public class SingletonExample2 {

    // 私有构造函数
    private SingletonExample2(){

    }

    // 单利对象
    private static SingletonExample2 singletonExample1 = new SingletonExample2();

    // 静态工厂方法
    public static SingletonExample2 getInstance(){
        return singletonExample1;
    }

}
