package com.demo.concurrency.example.singleton;

import com.demo.concurrency.annoations.NotRecommend;
import com.demo.concurrency.annoations.NotThreadSafe;
import com.demo.concurrency.annoations.ThreadSafe;

/**
 * 懒汉式
 * 单例实例在第一次使用的时候创建
 * Created by Wangpeng on 2018/6/13.
 */
@ThreadSafe
@NotRecommend
public class SingletonExample3 {

    // 私有构造函数
    private SingletonExample3(){

    }

    // 单利对象
    private static SingletonExample3 singletonExample1 = null;

    // 静态工厂方法
    public static synchronized SingletonExample3 getInstance(){
        if (singletonExample1 == null){
            singletonExample1 = new SingletonExample3();
        }
        return singletonExample1;
    }

}
