package math;

import java.util.Arrays;

public class OriginalGCD {
	
	
	public static void main(String[] args) {
		/*
		 int arr[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				 1, 1, 1, 5, 5, 5, 7, 10, 12, 2, 2}; 
				 */
		int arr[] = {5, 1, 1, 12}; 
		 findNumbers(arr);
	}

	private static void findNumbers(int[] arr) {
		// TODO Auto-generated method stub
		Arrays.sort(arr);
		reverse(arr);
		
		int freq[] = new int[arr[0] + 1];
		
		for(int i = 0 ; i < arr.length; i++) {
			freq[arr[i]]++;
		}
		
		int size = (int)Math.sqrt(arr.length);
		int[] result = new int[size];
		int x, l = 0;
		
		for(int i = 0 ; i < arr.length; i++) {
			if(freq[arr[i]] != 0 && l<size) {
				result[l] = arr[i];
				l++;
				freq[arr[i]]--;
				for(int j = 0; j < l; j++) {
					if(i != j) {
						x = gcd(arr[i],result[j]);
						freq[x] = freq[x] - 2;
					}
				}
			}
		}
		
		for(int i = 0 ; i < size; i++) {
			System.out.print(result[i] + " ");
		}
	}

	private static int gcd(int a, int b) {
		// TODO Auto-generated method stub
		if(b == 0)
			return a;
		return gcd(b, a%b);
	}

	private static void reverse(int[] arr) {
		// TODO Auto-generated method stub
		int middle = arr.length/2;
		int size = arr.length-1;
		for(int i = 0 ; i < middle; i++) {
			int temp = arr[i];
			arr[i] = arr[size - i];
			arr[size - i] = temp;
			
		}
	}

}
