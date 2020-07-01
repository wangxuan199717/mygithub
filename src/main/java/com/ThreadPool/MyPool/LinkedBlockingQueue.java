package com.ThreadPool.MyPool;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : wangxuan
 * @date : 15:14 2020/7/1 0001
 */
public class LinkedBlockingQueue<E> {
    private Queue<E> queue;
    private Object lock;

    public LinkedBlockingQueue(){
        queue = new LinkedList<>();
        lock = new Object();
    }
    public boolean add(E e){
        synchronized (lock){
            queue.add(e);
            lock.notify();
            return true;
        }
    }
    public E take(){
        synchronized (lock){
            while(queue.isEmpty()){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return queue.poll();
        }
    }
    public synchronized int size() {
        return queue.size();
    }
}
