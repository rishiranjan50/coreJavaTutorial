package com.rishi.balancedTree;

public class A 
{
  public static void main(String[] args) {
	
	  String[] a={"abcd","efgh","defg"};
	  String[] b = {"badc","fehg","defg"};
	  String[] twins= twins(a,b);
	 for(String temp:twins){
		 System.out.println(temp);
	 }
	 // System.out.println(isTwins("abcd","badc"));
}
  
	  static String[] twins(String[] a, String[] b) {
		  	int max = Math.max(a.length, b.length);
			String[] twins=new String[max];
		  for(int i=0;i<max;i++){
			  if(isTwins(a[i],b[i])){
				  twins[i]="yes";
			  }else{
				  twins[i]="no";
			  }
		  }
		  
		  return twins;
	  }
	  
	  static boolean isTwins(String a , String b){
		  
		  if(a.length()!=b.length())
			  return false;
		  int indexB;
		  for(int i=0;i<a.length();i++){
			  if(i%2==0){
				  indexB = i+1;
			  }else{
				  indexB=i-1;
			  }
			 if( a.charAt(i)!=b.charAt(indexB))
				 return false;
			 
		  }
		 
		  return true;
	  }
	  
// find number of cons number to find sum
	  // 10 - 1+2+3+4 ---
	  //15 - 4+5+6, 7+8, 1+2+3+4+5
	  
	 static int[] consicutiveNumbers(int number){
		 int sum=0;
		 int[] arrays;
		 int index =0;
		 for(int i=number/2+1;i>0;i--){
			 sum = sum+i;
			// arrays[index++]=i;
				// return arrays;
		 }
		 return null;
	 }

}
