package com.rishi.generic;

public class Test2 {
public static void main(String[] args) {
	String str1="str1";
	String str2 = "str2";
	str1=str1+str2;
	str2= str1.substring(0,str1.length()-str2.length());
	str1 = str1.substring(str2.length());
	System.out.println(str1+"**"+str2);
	
}
}
