package com.elink.test;

import java.lang.ref.SoftReference;
import java.util.concurrent.CountDownLatch;

public class TestNotify implements Runnable {
	    private final Object obj = new Object();  
	    private Integer number = 0;
	    CountDownLatch countDownLatch;
	    @Override  
	    public void run() {  
	        synchronized (this.number) { 
	        	System.out.println(Thread.currentThread().getName()+":"+number);
	        	number += 1;
	        	this.countDownLatch.countDown();
	            //obj.notify();  
	            //obj.notify();  
	        }  
	    }  
	    
	    public TestNotify(CountDownLatch countDownLatch) {
	    	this.countDownLatch = countDownLatch;
	    }
	  
	    public static void main(String[] args) {  
	        //ShareVars shareVars = new ShareVars(); 
	    	CountDownLatch countDownLatch = new CountDownLatch(3);
	    	TestNotify testNotify = new TestNotify(countDownLatch);
	        new Thread(testNotify).start();  
	        new Thread(testNotify).start();  
	        new Thread(testNotify).start();
	        
	        try {
				countDownLatch.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	        System.out.println(testNotify.number);
	        
	        SoftReference<String> softReference = new SoftReference<String>(new String(""));
	    }  
}
