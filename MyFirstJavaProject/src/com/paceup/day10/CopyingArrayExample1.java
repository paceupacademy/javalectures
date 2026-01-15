package com.paceup.day10;
//Copying Arrays Using Assignment Operator
public class CopyingArrayExample1 {
	public static void main(String[] args) {

		int [] numbers = {1, 2, 3, 4, 5, 6, 7,23,23,2,3123,23,23,213,213,21,3,21,321,3,21,321,3,123 -1, -2, -3, -4, -5, -6};
		int[] positiveNumbers = new int[numbers.length]; 
		int[] negNumbers =  new int[numbers.length];// copying arrays
		int i = 0, j=0;
		for (int pnumber: numbers) {
			if(pnumber>0) {
				positiveNumbers[i]=pnumber;
				System.out.print(positiveNumbers[i]+" , ");
				i++;
			}
			else {
				negNumbers[j]=pnumber;
				j++;
			}
			
		}
		System.out.print("Negative numbers: ");
		for(int n: negNumbers) {
			System.out.print(n+", ");
		}
		
	}
}
