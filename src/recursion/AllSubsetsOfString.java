package recursion;

/*
 * 
 * Given String
 * Print all the subsets in any order.
 * Example : "ABC"
 * O/P : "","A","B,"C","AB","AC","BC","ABC"
 */

public class AllSubsetsOfString {
	public static void main(String[] args) {
		String str = "ABC";
		String curr = "";
		int index = 0;
		solve(str, curr, index);
	}

	private static void solve(String str, String curr, int index) {
		if(index == str.length()) {
			System.out.println(curr);
			return;
		}
		solve(str, curr, index + 1);
		solve(str, curr + str.charAt(index), index + 1);
	}
}
