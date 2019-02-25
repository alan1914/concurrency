package com.mmall.concurrency.example.threadlocal;

/**
 * @author stone
 * @des TODO
 * @date 2019/2/25/025 16:24
 **/
public class RequestHolder {


    private final static ThreadLocal<Long> requestHolder = new ThreadLocal<>();

    public static void add(Long id){
        requestHolder.set(id);
    }

    public static Long getId(){
        return requestHolder.get();
    }

    public static void remove(){
        requestHolder.remove();
    }







}
