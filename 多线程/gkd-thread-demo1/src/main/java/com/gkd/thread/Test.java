package com.gkd.thread;

public class Test {

    public static void main(String[] args) {
        Resource resource = new Resource();

        new Thread(new Producer(resource)).start();
        new Thread(new Consumer(resource)).start();
    }
}
