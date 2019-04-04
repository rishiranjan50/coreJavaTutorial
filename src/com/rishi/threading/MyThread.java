package com.rishi.threading;

public class MyThread {

	public static class EvenThread extends Thread {
		Boolean evenFlag;
		Integer sharedCount;

		public EvenThread(Boolean flag, Integer count) {
			this.evenFlag = flag;
			this.sharedCount = count;
		}

		public void run() {

			printEven();

		}

		private void printEven() {

			for (int i = 0; i < 10; i++) {
				synchronized (evenFlag) {
					if (!evenFlag) {
						try {
							evenFlag.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
					evenFlag = false;
					System.out.println("even thread :" + sharedCount++);
					notifyAll();
				}
			}
		}
	}

	public static class OddThread extends Thread {
		Boolean evenflag;
		Integer sharedCount;

		public OddThread(Boolean flag, Integer count) {
			this.evenflag = flag;
			this.sharedCount = count;
		}

		public void run() {

			printOdd();
		}

		private void printOdd() {
			// TODO Auto-generated method stub

			for (int i = 0; i < 10; i++) {
				synchronized (evenflag) {
					if (evenflag) {
						try {
							evenflag.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
					evenflag = true;
					System.out.println("odd thread :" + sharedCount++);
					notifyAll();
				}
			}
		}
	}

	public static void main(String[] args) {
		final Boolean evenFlag = new Boolean(true);
		Integer sharedCount = new Integer(0);
		EvenThread thread1 = new EvenThread(evenFlag, sharedCount);
		thread1.setName("evenThread");
		OddThread thread2 = new OddThread(evenFlag, sharedCount);
		thread2.setName("oddthread");
		thread1.start();
		thread2.start();
	}
}
