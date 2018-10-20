package com.git.java;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Sathish
 *
 *This solution is used for below use case,
 *
 *When 5 numbers given as input, use three operators (+, -, *) with four operations to find out the result is matching 42 (in this example)
 *and break out of the loop by printing YES
 *
 */
public class CombinationPblm {

	static List<char[]> operationCombination = new ArrayList<>();
	static List<int[]> numberPermutation = new ArrayList<>();

	private static void permute(int[] a, int k) 
	{
		if (k == a.length) 
		{
			numberPermutation.add(a.clone());
		} 
		else 
		{
			System.out.println("K>>>>>>"+k);
			for (int i = k; i < a.length; i++) 
			{
				//System.out.println("K+++++++"+k);
				int temp = a[k];
				a[k] = a[i];
				a[i] = temp;

				//System.out.println(Arrays.toString(a));
				permute(a, k + 1);

				temp = a[k];
				a[k] = a[i];
				a[i] = temp;
				//System.out.println("End of K>>>>"+k);
			}
		}

	}

	static void printAllKLengthCharacter(char[] set, int k) 
	{ 
		int n = set.length; 
		combinate(set, "", n, k); 
	}

	static void combinate(char[] set, String prefix, int n, int k) 
	{ 
		if (k == 0) 
		{  	
			operationCombination.add(prefix.toCharArray());
			return; 
		} 

		for (int i = 0; i < n; ++i) 
		{  
			String newPrefix = prefix + String.valueOf(set[i]); 
			combinate(set, newPrefix, n, k - 1); 
		} 
	}

	private static int  operation( int a , int b, char operation) {
		if(operation == '*') {
			return a*b;
		}else if (operation == '-') {
			return a-b;
		}else if (operation == '+') {
			return a+b;
		}
		return 0;
	}

	public static void main(String[] args){

		int[] sequenceNoInput = {40, 1, 3, 4, 20};
		permute(sequenceNoInput, 0);	

		char[] optSet = {'*', '-','+'}; 
		int k= 4;
		printAllKLengthCharacter(optSet, k); 

		numIter: for(int i=0; i<numberPermutation.size(); i++) {

			int[] numArr = numberPermutation.get(i);

			for(int j=0; j<operationCombination.size(); j++) {
				char[] oprArr = operationCombination.get(j);
				int result = operation(numArr[0], numArr[1], oprArr[0]);
				result = operation(result, numArr[2], oprArr[1]);
				result = operation(result, numArr[3], oprArr[2]);
				result = operation(result, numArr[4], oprArr[3]);
				if(result == 42) {
					System.out.println("YES");
					break numIter;
				}
			}
		}
	}
}
