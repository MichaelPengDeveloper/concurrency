package com.demo.concurrency.example.singleton;

import com.demo.concurrency.annoations.ThreadSafe;

/**
 * 饿汉式
 * 单例实例在类装载的时候创建
 * Created by Wangpeng on 2018/6/13.
 */
@ThreadSafe
public class SingletonExample6 {

    // 私有构造函数
    private SingletonExample6(){

    }

    // 单利对象
    private static SingletonExample6 singletonExample1 = null;

    static {
        singletonExample1 = new SingletonExample6();
    }

    // 静态工厂方法
    public static SingletonExample6 getInstance(){
        return singletonExample1;
    }

    public static void main(String[] args) {
        System.out.println(getInstance().hashCode());
        System.out.println(getInstance().hashCode());
    }

}
