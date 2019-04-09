package com.rishi.dynamicProgramming;

public class TestLargestCommonSequence {

	public static void main(String[] args) {
		String w1="ABCBDAB";
		String w2="BDCABA";
		System.out.println("Starting time :--"+System.currentTimeMillis());
		System.out.println(findlargestCommonSequence(w1,w2));
		
		System.out.println("End time :--"+System.currentTimeMillis());
	}

	private static String findlargestCommonSequence(String w1, String w2) {
		// TODO Auto-generated method stub
		if(w1.length()==1 || w2.length()==1){
			char chr =  w1.charAt(w1.length()-1)==w2.charAt(w2.length()-1) ? w1.charAt(w1.length()-1) : '\0';
			return Character.toString(chr);
		}
		if(w1.charAt(w1.length()-1)==w2.charAt(w2.length()-1)){
			return findlargestCommonSequence(w1.substring(0,w1.length()-1),w2.substring(0, w2.length()-1)).concat(w1.substring(w1.length()-1));
		}
		
		else{
			return getMax(findlargestCommonSequence(w1, w2.substring(0,w2.length()-1)),findlargestCommonSequence(w1.substring(0, w1.length()-1), w2));
		}
	}

	private static String getMax(String substring, String substring2) {
		// TODO Auto-generated method stub
		return substring.length() >= substring2.length() ? substring :substring2;
	}
}
