package com.ThreadPool.MyPool;

/**
 * @author : wangxuan
 * @date : 15:25 2020/7/1 0001
 */
public class ThreadPool {
    private int coreSize;
    private boolean stop = false;
    private LinkedBlockingQueue<Runnable> tasks = new LinkedBlockingQueue<>();
    private Thread[] threads;

    public ThreadPool(int coreSize)  {
        this.coreSize = coreSize;
        threads = new Thread[coreSize];
        for (int i = 0; i < coreSize; i++) {
            threads[i] = new Thread(new Worker("thread"+i));
            threads[i].start();
        }
    }

    public boolean submit(Runnable command) {
        return tasks.add(command);
    }

    public void shutdown() {
        stop = true;
    }

    private class Worker implements Runnable {
        public String name;

        public Worker(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            while (!stop) {
                Runnable command = tasks.take();
                System.out.println(name + " start run, starttime " + System.currentTimeMillis()/1000);  //方便观察线程的执行情况
                command.run();
                System.out.println(name + " finished, endtime " + System.currentTimeMillis()/1000);
            }
        }
    }
}
