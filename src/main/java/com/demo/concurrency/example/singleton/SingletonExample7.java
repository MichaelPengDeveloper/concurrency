package com.demo.concurrency.example.singleton;

import com.demo.concurrency.annoations.Recommend;
import com.demo.concurrency.annoations.ThreadSafe;

/**
 * 枚举模式
 * Created by Wangpeng on 2018/6/13.
 */
@ThreadSafe
@Recommend
public class SingletonExample7 {

    // 私有构造函数
    private SingletonExample7(){

    }

    public static SingletonExample7 getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton{
        INSTANCE;

        private SingletonExample7 singletonExample7;

        // JVM这个方法只调用一次
        Singleton(){
            singletonExample7 = new SingletonExample7();
        }

        public SingletonExample7 getInstance(){
            return singletonExample7;
        }

    }

}
