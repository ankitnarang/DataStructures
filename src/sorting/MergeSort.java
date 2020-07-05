package sorting;

public class MergeSort {
	
	public static void main(String[] args) {
		int[] arr = {10, 7, 8, 9, 1, 5,1,5,4,7,19};
		printArray(arr);
		sort(arr, 0, arr.length-1);
		printArray(arr);
	}
	
	static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+" "); 
        System.out.println(); 
    }

	private static void sort(int[] arr, int low, int high) {
		// TODO Auto-generated method stub
		if(low < high) {
			int mid = (low + high)/2;
			sort(arr, low, mid);
			sort(arr, mid+1, high);
			merge(arr, low, mid, high);
		}
	}

	private static void merge(int[] arr, int low, int mid, int high) {
		
		int n1 = mid - low + 1;
		int n2 = high - mid;
		int[] left = new int[n1];
		int[] right = new int[n2];
		
		for(int i = 0; i < n1; i++) {
			left[i] = arr[low + i];
		}
		
		for(int j = 0; j < n2; j++) {
			right[j] = arr[mid + 1 + j];
		}
		
		int i = 0, j = 0 , k = low;
		
		while(i < n1 && j < n2) {
			
			if(left[i] <= right[j]) {
				arr[k] = left[i];
				i++;
			} else {
				arr[k] = right[j];
				j++;
			}
			k++;
			
		}
		
		while(i < n1) {
			arr[k++] = left[i++]; 
		}
		
		while(j < n2) {
			arr[k++] = right[j++]; 
		}
		
	}
	
}
