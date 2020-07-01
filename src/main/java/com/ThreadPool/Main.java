package com.ThreadPool;

import com.ThreadPool.MyPool.ThreadPool;

/**
 * @author : wangxuan
 * @date : 15:12 2020/7/1 0001
 */
public class Main {
    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool(5);
        for(int i=0;i<20;i++){
            threadPool.submit(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
//        try {
//            Thread.sleep(10000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        threadPool.shutdown();
    }
}
