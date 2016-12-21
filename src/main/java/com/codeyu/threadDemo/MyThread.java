package com.codeyu.threadDemo;

/**
 * Created by zhuyu on 16/12/21.
 */
public class MyThread extends Thread{
    boolean waiting= true;
    boolean ready= false;
    MyThread() {
    }
    public void run() {
        String thrdName = Thread.currentThread().getName();
        System.out.println(thrdName + " 启动");
        while(waiting)
            System.out.println("等待："+waiting);
        System.out.println("等待...");
        startWait();
        try {
            Thread.sleep(1000);
        }
        catch(Exception exc) {
            System.out.println(thrdName + " 中断。");
        }
        System.out.println(thrdName + " 结束。");
    }
    synchronized void startWait() {
        try {
            while(!ready) wait();
        }
        catch(InterruptedException exc) {
            System.out.println("wait() 中断。");
        }
    }
    synchronized void notice() {
        ready = true;
        notify();
    }
}
