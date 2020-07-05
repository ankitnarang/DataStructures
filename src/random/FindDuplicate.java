package random;

public class FindDuplicate {
	public static void main(String[] args) {
		int[] array = {3,1,2,1,2}; 
		// '1' will get displayed since it's appearing more than once before '2'
		System.out.println("Duplicate element in the array is " + repeatNumber(array));
	}

	private static int repeatNumber(int[] array) {
		int[] count = new int[array.length];
		for(int i = 0 ; i < array.length; i++) {
			count[i] = 0;
		}
		for(int i = 0 ; i < array.length; i++) {
			count[array[i]]++;
			if(count[array[i]] > 1)
				return array[i];
		}
		return -1;
	}
}
