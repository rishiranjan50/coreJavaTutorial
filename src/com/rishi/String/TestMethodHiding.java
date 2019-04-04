package com.rishi.String;

public class TestMethodHiding {



  
  public static void main(String[] args) {
	Base base = new Base();
	Child chld = new Child();
	Base chld2 = new Child();
	
	base.printMe();
	chld.printMe();
	chld2.printMe();
}
}

 class Base{
	  
	   static void printMe(){
		  System.out.println("Base print me ");
	  }
}
 
  class Child extends Base{
	  
	    static void printMe(){
		  System.out.println("Child print me");
	  }
}
