package com.rishi.generic;

public class Test {

	static class Myclass {
		public void method1() throws InterruptedException {
			synchronized (this) {
				for (int i = 0; i < 10; i++) {
					System.out.println("1");
					notify();
					wait();
				}
			}
		}

		public void method2() throws InterruptedException {
			synchronized (this) {
				for (int i = 0; i < 10; i++) {
					System.out.println("2");
					notify();
					wait();
				}
			}
		}
	}

	public static void main(String[] args) {
		Myclass obj = new Myclass();
		Thread t1 = new Thread() {
			public void run() {
				try {
					obj.method1();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};

		Thread t2 = new Thread() {
			public void run() {
				try {
					obj.method2();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};

		t1.start();
		t2.start();
	}
}