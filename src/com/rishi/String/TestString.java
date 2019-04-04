package com.rishi.String;
import java.util.Iterator;
import java.util.HashSet;
import java.util.Set;
import java.util.ListIterator;
import java.util.ArrayList;
public class TestString {
	public static void main(String[] args) {
			System.out.println(isPalindrom("abba"));
			ArrayList<String> list = new ArrayList<>();
			list.listIterator();
	}

	public static boolean isPalindrom(String ip) {

		int left=0;
		int right = ip.length()-1;
		
		char[] ipArry=ip.toCharArray();
		for(int i=0;i<ipArry.length/2;i++){
			
			if(ipArry[left]!=ipArry[right]){
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}
