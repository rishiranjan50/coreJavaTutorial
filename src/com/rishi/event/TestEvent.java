package com.rishi.event;

public class TestEvent {
	public static void main(String[] args) {
		MyEventListner listner= new MyEventListner();
		MyEvent event = new MyEvent(listner);
		event.event1();
		event.event2();
	}
}

class MyEvent{
	MyEventListner listner;
	
	public MyEvent(MyEventListner listner){
		this.listner=listner;
	}
	public void event1(){
		listner.listen1();
	}
	
	public void event2(){
		listner.listen2();
	}
}

class MyEventListner{
	
	public void listen1(){
		System.out.println("Listing event1");
	}
	
	public void listen2(){
		System.out.println("Listing event2");
	}
}