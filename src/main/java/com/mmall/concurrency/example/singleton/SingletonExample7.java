package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annotations.Recommend;
import com.mmall.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 枚举模式
 *
 * @author stone
 **/
@ThreadSafe
@Slf4j
@Recommend
public class SingletonExample7 {

    // 私有的构造函数
    private SingletonExample7() {
    }

    // 静态的工厂方法
    public static SingletonExample7 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton{
        INSTANCE;

        private SingletonExample7 singleton;

        // JVM 保证这个方法绝对只被调用一次
        Singleton(){
            singleton = new SingletonExample7();
        }

        public SingletonExample7 getInstance(){
            return singleton;
        }
    }
}