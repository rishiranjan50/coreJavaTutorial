package com.rishi.sorting;

public class TestSorting {

	/*
	 * Bubble sort compares first two element and exchange the position and so on.
	 * order - n2 , no extra space
	 */	
	public static void bubbleSort(int[] arr){
	
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr.length-i-1;j++){
				if(arr[j]>arr[j+1]){
					int temp = arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
	}
	
	public static void quickSort(int[] arr,int start,int end){
		int sorted = partition(arr, start,end);
		if(sorted != -2){
		quickSort(arr,start,sorted-1);
		quickSort(arr,sorted+1,end);
		}
	}
	
	public static int partition(int[] arr,int start,int end){
		if(start >= end)
			return -2;
		int pivot = end;
		int leftPointer = start - 1;
		while (start < pivot) {
			if(arr[start] < arr[pivot]){
				//if(leftPointer+1 != start){
				int temp = arr[++leftPointer];
				arr[leftPointer]= arr[start];
				arr[start]=temp;
				//}
			}
			start++;
		}
		
		// exchange with pivot
		int temp11 = arr[pivot];
		arr[pivot]= arr[++leftPointer];
		arr[leftPointer]=temp11;
		return leftPointer;
	}
	
	public static void main(String[] args) {
		int[] arr = {15,3,18,2,19,4,20,6};
		quickSort(arr,0,arr.length-1);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+"	,");
		}
	}
}
