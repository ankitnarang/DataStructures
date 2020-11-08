package arrays;

public class SortZeroesOnes {
	
	public static void main(String[] args) {
		int[] arr = {0,1,1,0,0,0,1,0,1};
		System.out.println("Before Sorting : ");
		for(int i = 0 ; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		sort(arr);
		System.out.println("\nAfter Sorting : ");
		for(int i = 0 ; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}

	private static void sort(int[] arr) {
		int low = 0;
		int high = arr.length-1;
		while(low < high) {
			while(arr[low] == 0 && low < high)
				low++;
			while(arr[high] == 1 && low < high)
				high--;
			if(low < high) {
				arr[low] = 0;
				arr[high] = 1;
				low++;
				high--;
			}
		}
	}

}
