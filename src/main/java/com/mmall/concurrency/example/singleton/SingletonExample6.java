package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 静态代码块
 * 单例实例在第一次使用时创建
 *
 * @author stone
 **/
@ThreadSafe
@Slf4j
public class SingletonExample6 {

    // 私有的构造函数
    private SingletonExample6() {
    }

    // 单例对象
    private volatile static SingletonExample6 instance = null;

    // 注意 静态代码会顺序执行 注意空指针异常
    static {
        instance = new SingletonExample6();
    }

    // 静态的工厂方法
    public static SingletonExample6 getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        log.info("{}", getInstance().hashCode());
        log.info("{}", getInstance().hashCode());
    }
}