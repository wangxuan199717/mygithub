package com.others;

import java.util.Random;

public class Others {
    public static void main(String[] args) {
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

        int i=5;
        while(i--!=0)
        new Thread(() -> {
            threadLocal.set(new Random().nextInt(10));
            System.out.println(threadLocal.get());
            try {
                Thread.currentThread().sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
