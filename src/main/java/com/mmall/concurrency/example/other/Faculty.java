package com.mmall.concurrency.example.other;

/**
 * @author stone
 * @des TODO
 * @date 2019/2/21/021 17:18
 **/
public class Faculty extends Employee {
    public Faculty() {
        System.out.println("(3)Performs Faculty's tasks");
    }

    public static void main(String[] args) {
        Faculty fac = new Faculty();
    }
}
