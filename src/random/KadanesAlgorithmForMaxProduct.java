package random;

public class KadanesAlgorithmForMaxProduct {
	
	public static void main(String[] args) {
		int[] arr = {1, -2, -3, 0, 7, -8, -2};
		int maxProd = maxProductSubarray(arr);
		System.out.println("Maximum Sub array product is " + maxProd);
	}

	private static int maxProductSubarray(int[] arr) {
		int maxEndingHere = 1;
		int minEndingHere = 1;
		int maxSofar = 1;
		int flag = 0;
		
		for(int i = 0 ; i < arr.length; i++) {
			if(arr[i] > 0) {
				maxEndingHere = maxEndingHere * arr[i];
				minEndingHere = Math.min(minEndingHere * arr[i], 1);
				flag = 1;
			} else if(arr[i] == 0) {
				maxEndingHere = 1;
				minEndingHere = 1;
			} else {
				int temp = maxEndingHere;
				maxEndingHere = Math.max(minEndingHere * arr[i],1);
				minEndingHere = temp * arr[i];
			}
			if(maxSofar < maxEndingHere) {
				maxSofar = maxEndingHere;
			}
			
		}
		
		if(maxSofar == 1 && flag == 0) {
			return 0;
		}
		
		return maxSofar;
	}

}
