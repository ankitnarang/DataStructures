package sorting;


public class QuickSort {
	
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
		if(low < high) {
			int pi = partition(arr,low,high);
			sort(arr, low, pi-1);
			sort(arr, pi+1, high);
		}
	}

	private static int partition(int[] arr, int low, int high) {
		int i = low - 1;
		int pivot = arr[high];
		int temp = -1;
		for(int j = low; j < high; j++) {
			if(arr[j] < pivot) {
				i++;
				//swap
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		//swap
		temp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = temp;
		return i+1;
	}
}
