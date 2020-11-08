package strings;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/*
 * 
 * Rearrange characters in a string such that no two adjacent are same
 * Input: aaabc 
 * Output: abaca 
 * 
 */

public class RearrangeString {
	public static void main(String[] args) {
		String str = "aaacbbdddd";
		rearrange(str);
	}

	private static void rearrange(String str) {
		int length = str.length();
		int[] count = new int[26];
		
		for(int i = 0; i < str.length(); i++ ) {
			count[str.charAt(i) - 'a']++;
		}
		
		PriorityQueue<Key> queue = new PriorityQueue<Key>(new KeyComparator());
		
		for(char ch = 'a'; ch <= 'z';ch++) {
			int val = ch - 'a';
			if(count[val] > 0) {
				queue.add(new Key(count[val],ch));
			}
		}
		/*
		Iterator<Key> itr = queue.iterator();
		while(itr.hasNext()) {
			Key key = (Key)itr.next();
			System.out.println(key.ch + " " + key.frequency);
		}
		*/
		Key prev = new Key(-1, '#');
		str = "";
		
		while(queue.size() != 0) {
			Key k = queue.peek();
			queue.poll();
			str = str + k.ch;
			if(prev.frequency > 0) {
				queue.add(prev);
			}
			k.frequency--;
			prev = k;
		}
		if(length != str.length())
			System.out.println("Not possible to rearrange");
		else
			System.out.println("Rearranged string is " + str);
		
	}
}
class Key{
	int frequency;
	char ch;
	
	public Key(int frequency, char ch) {
		this.frequency = frequency;
		this.ch = ch;
	}
}
class KeyComparator implements Comparator<Key>{
	@Override
	public int compare(Key o1, Key o2) {
		if(o1.frequency > o2.frequency)
			return -1;
		if(o1.frequency < o2.frequency)
			return 1;
		return 0;
	}
}
