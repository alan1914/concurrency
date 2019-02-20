package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annotations.ThreadSafe;

/**
 * 饿汉模式
 * 单例实例在第一次使用时创建
 *
 * @author stone
 **/
@ThreadSafe
public class SingletonExample2 {

    // 私有的构造函数
    private SingletonExample2() {
    }

    // 单例对象
    private static SingletonExample2 instance = new SingletonExample2();

    public static SingletonExample2 getInstance() {
        return instance;
    }
}
