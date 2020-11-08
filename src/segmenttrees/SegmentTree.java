package segmenttrees;

public class SegmentTree {
	
	int st[];
	
	public SegmentTree(int[] arr, int n) {
		int x = (int)Math.ceil(Math.log(n)/Math.log(2));
		int maxSize = 2 * (int)Math.pow(2, x);
		st = new int[maxSize];
		constructSTUtil(arr,0,n-1,0);
	}

	private int constructSTUtil(int[] arr, int ss, int se, int si) {
		if(ss == se) {
			st[si] = arr[ss];
			return arr[ss];
		}
		
		int mid = getMid(ss,se);
		st[si] = constructSTUtil(arr,ss,mid,2 * si + 1) +
				constructSTUtil(arr,mid+1,se,2 * si + 2);
		return st[si];
	}

	private int getMid(int start, int end) {
		return start + (end - start)/2;
	}
	
	private int getSum(int n, int qs, int qe) {
		if(qs < 0 || qe > n-1 || qs > qe) {
			System.out.println("Invalid input");
			return -1;
		}
		return getSumUtil(0,n-1,qs,qe,0);
	}

	private int getSumUtil(int ss, int se, int qs, int qe, int si) {
		if(qs <= ss && qe >= se) {
			return st[si];
		}
		
		if(se < qs || ss > qe) {
			return 0;
		}
		
		int mid = getMid(ss, se);
		return  getSumUtil(ss, mid, qs, qe, 2 * si + 1) + 
				getSumUtil(mid+1, se, qs, qe, 2 * si + 2);
	}
	
	private void updateValue(int[] arr, int n, int i, int newValue) {
		if(i < 0 || i > n-1) {
			System.out.println("Invalid input");
			return;
		}
		
		int diff = newValue - arr[i];
		arr[i] = newValue;
		updateValueUtil(0,n-1,i,diff,0);
	}
	
	private void updateValueUtil(int ss, int se, int i, int diff, int si) {
		if(i < ss || i > se) {
			return;
		}
		
		st[si] = st[si] + diff;
		if(ss != se) {
			int mid = getMid(ss, se);
			updateValueUtil(ss, mid, i, diff, 2 * si + 1);
			updateValueUtil(mid + 1, se, i, diff, 2 * si + 2);
		}
		
	}

	public static void main(String[] args) {
		int arr[] = {1,3,5,7,9,11};
		int n = arr.length;
		SegmentTree segmentTree = new SegmentTree(arr, n);
		System.out.println("Sum of values in given range " + segmentTree.getSum(n, 2, 5));
		segmentTree.updateValue(arr,n,5,3);
		System.out.println("Updated sum of values of given range " + segmentTree.getSum(n, 2, 5));
	}

}
