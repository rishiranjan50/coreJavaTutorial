package com.rishi.threading;

import java.util.ArrayList;
import java.util.List;

public class CPExample {
	static class Resource{
		Resource(int len){
			this.maxLength=len;
			resourceList=new ArrayList();
		}
		int maxLength;
		List<Integer> resourceList;
		
		public synchronized void putResource(int i){
			if(resourceList.size()==maxLength){
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName()+" :produced :"+i );
			resourceList.add(i);
			this.notifyAll();
		}
		
		public synchronized void consumeResource(){
			if(resourceList.size()==0){
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName()+" :consumed :"+resourceList.get(0));
			resourceList.remove(0);
			this.notifyAll();
		}
	}

	static class Consumer implements Runnable{
		Resource res;
		Consumer(Resource res){
			this.res=res;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			for(int i=0;i<20;i++){
				res.consumeResource();
			}
		}
		
	}
	
	static class Producer implements Runnable{
		Resource res;
		Producer(Resource res){
			this.res=res;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			for(int i=0;i<20;i++){
				res.putResource(i);
			}
		}
		
	}
	
	public static void main(String[] args) {
		Resource resource = new Resource(10);
		Consumer cons = new Consumer(resource);
		Producer prod = new Producer(resource);
		Thread t1 = new Thread(cons);
		t1.setName("t1");
		Thread t2 = new Thread(prod);
		t2.setName("t2");
		Thread t3 = new Thread(cons);
		t3.setName("t3");
		Thread t4 = new Thread(prod);
		t4.setName("t4");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
