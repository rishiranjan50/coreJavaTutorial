package com.rishi.threading;

import java.util.LinkedList;
import java.util.List;

import javax.swing.plaf.SliderUI;

public class ConsumerProducerExample {

	public static void main(String[] args) throws InterruptedException {
		// create shared resources
		Resource resource = new Resource();
		Consumer consumer = new Consumer(resource);
		Producer producer = new Producer(resource);
		
		Thread t1 = new Consumer(resource);//new Thread(consumer);
		Thread t2 = new Consumer(resource);//new Thread(consumer);
		//Thread t3 = new Consumer(resource);//new Thread(consumer);
		Thread t3 = new Producer(resource);//new Thread(producer);
		Thread t4 =new Producer(resource);// new Thread(producer);
		
		System.out.println("Starting thread");
		t1.start();
		t1.sleep(100);
		t3.start();
		t3.sleep(100);
		t2.start();
		t2.sleep(100);
		t4.start();
		t4.sleep(100);
	}
}

class Resource{
	 static int maxCount = 10;
	 List<Integer> resourcelist;
	 
	 public Resource(){
		 resourcelist=new LinkedList<Integer>();
	 }
	 
	 synchronized public void putResource(int i) throws InterruptedException{
		 System.out.println("Putting:"+i);
		 if(resourcelist.size()>= maxCount){
			 System.out.println("put in wait***");
			 wait();
		 }
		 resourcelist.add(i);
		 notifyAll();
	 }
	 
	 synchronized public void consumeResource() throws InterruptedException{
		 if(resourcelist.size()<= 0){
			 System.out.println("consume in wait**");
			 wait();
		 }
		 System.out.println("consumming resources :"+resourcelist.get(0));
		 resourcelist.remove(0);
		 notifyAll(); 
	 }
	 
}
class Consumer extends Thread{
	Resource resource;
	public Consumer(Resource resource) {
		// TODO Auto-generated constructor stub
		this.resource=resource;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++){
			try {
				resource.consumeResource();
			
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

class Producer extends Thread{
	Resource resource;
	public Producer(Resource resource) {
		// TODO Auto-generated constructor stub
		this.resource=resource;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++){
			try {
				resource.putResource(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}