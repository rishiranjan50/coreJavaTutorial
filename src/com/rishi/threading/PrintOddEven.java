package com.rishi.threading;

public class PrintOddEven {
	static class Resource {
		int sharedCount;
		int maxLength;

		Resource(int max) {
			this.maxLength = max;
		}

		public synchronized void printOdd() {
			if (sharedCount % 2 == 0) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName()+" : "+sharedCount);
			sharedCount++;
			notifyAll();
		}

		public synchronized void printEven() {
			if (sharedCount % 2 != 0) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName()+" : "+sharedCount);
			sharedCount++;
			notifyAll();
		}
	}
	
	public static void main(String[] args) {
		Resource res = new Resource(100);
		Thread t1 = new Thread(){
			public void run(){
				for(int i=0;i<100;i++){
					res.printEven();
				}
			}
		};
		
		Thread t2 = new Thread(){
			public void run(){
				for(int i=0;i<100;i++){
					res.printOdd();
				}
			}
		};
		t1.start();
		t2.start();
	}
}
