package com.gkd.thread;

public class Resource {
    private int num = 0;
    private boolean flag = false;


    public synchronized void create() {
        if (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        num++;
        System.out.println(Thread.currentThread().getName() + "生产者-----------" + num);
        flag = true;
        notify();
    }

    public synchronized void destroy() {
        if (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "消费者************" + num);
        flag = false;
        notify();
    }
}
