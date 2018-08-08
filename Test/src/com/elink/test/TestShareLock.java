package com.elink.test;


/**
 * @author gang
 */
public class TestShareLock {
    public static void main(String[] args) {
        Thread t1 = new Thread(new DeadLockclasse(true));//建立一个线程
        Thread t2 = new Thread(new DeadLockclasse(false));//建立另一个线程
        t1.start();//启动一个线程
        t2.start();//启动另一个线程
    }
}
class DeadLockclasse implements Runnable {
    public boolean falg;// 控制线程
    DeadLockclasse(boolean falg) {
        this.falg = falg;
    }
    public void run() {
        /**
         * 如果falg的值为true则调用t1线程
         */
        if (falg) {
            while (true) {
                synchronized (Suoo.o2) {
                    System.out.println("o1 " + Thread.currentThread().getName());
                    synchronized (Suoo.o1) {
                        System.out.println("o2 " + Thread.currentThread().getName());
                    }
                }
            }
        }
        /**
         * 如果falg的值为false则调用t2线程
         */
        else {
            while (true) {
                synchronized (Suoo.o1) {
                	System.out.println("o2 " + Thread.currentThread().getName());
                    synchronized (Suoo.o2) {
                       System.out.println("o1 " + Thread.currentThread().getName());
                    }
                }
            }
        }
    }
}

class Suoo {
    static Object o1 = new Object();
   // static Integer index = 0;
   static Object o2 = new Object();
}
