
package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annotations.ThreadSafe;

/**
 * 懒汉模式 线程安全
 * 单例实例在第一次使用时创建
 *
 * @author stone
 **/
@ThreadSafe
public class SingletonExample3 {

    // 私有的构造函数
    private SingletonExample3() {
    }

    // 单例对象
    private static SingletonExample3 instance = null;

    // 静态的工厂方法
    public synchronized static SingletonExample3 getInstance() {
        if (instance == null) {
            instance = new SingletonExample3();
        }
        return instance;
    }
}

