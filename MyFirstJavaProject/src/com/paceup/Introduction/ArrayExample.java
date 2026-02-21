package com.paceup.Introduction;
/*
 * Given an unsorted integer array, print a pair with the given sum in it.
 
For example,
 
 
Input:
nums = [8, 7, 2, 5, 3, 1]
target = 10
Output:
Pair found (8, 2) 
or
Pair found (7, 3)

Input:
nums = [5, 2, 6, 8, 1, 9]
target = 12
Output: Pair not found
 */
public class ArrayExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {8,4,5,6,8};
		int target1=11;
		String s=pairData(arr,target1);
		System.out.println(s);

	}
	
	public static String pairData(int[] arr, int target) {
		String str=null;
		for(int i =0; i<arr.length; i++) {
			for(int j=0; j<arr.length-1; j++) {
				if(i!=j) {
					if(arr[j]+arr[i]==target) {
						str="Pair found for "+target+" ("+arr[j]+","+arr[i]+")";
					}
				}
			}
		}
		if(str==null) {
			str="Pair not found";
		}
		return str;
		
	}

}
