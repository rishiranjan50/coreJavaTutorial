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
	
	public static void quickSort(int[] arr){
		partition(arr, 0, arr.length-1);
	}
	
	public static void partition(int[] arr,int start,int end){
		int pivot = start;
		int leftPointer = start - 1;
		while (start <= end) {
			while (start <= end & arr[start] <= arr[pivot]) {
				start++;
			}
			while (start <= end & arr[end] >= arr[pivot]) {
				end--;
			}

			if (start < end) {
				int temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
				start++;
				end--;
			}
		}
		
		// put the pivot on its correct position
		int temp = arr[--start];
		arr[--start]= arr[pivot];
		arr[pivot]=temp;
		
		partition(arr, start, pivot-1);
		partition(arr, pivot+1, end);
	}
	
	public static void main(String[] args) {
		int[] arr = {15,3,18,2,19,4,20,6};
		quickSort(arr);
	}
}
