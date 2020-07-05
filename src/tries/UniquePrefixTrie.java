package tries;

import java.util.ArrayList;
import java.util.Arrays;

public class UniquePrefixTrie {
	
	static final int MAX = 256;
	static final int MAX_WORD_LENGTH = 500;
	
	static class TrieNode{
		TrieNode[] children = new TrieNode[MAX];
		int freq;
		TrieNode() {
			this.freq = 1;
			for(int i = 0 ;i < MAX; i++) {
				children[i] = null;
			}
		}
	}
	
	static TrieNode root;
	
	static void insert(String key){
		int len = key.length();
		TrieNode pCrawl = root;
		for(int level = 0; level < len; level++) {
			int index = key.charAt(level);
			if(pCrawl.children[index] == null) {
				pCrawl.children[index] = new TrieNode();
			} else {
				(pCrawl.children[index].freq)++;
			}
			pCrawl = pCrawl.children[index];
		}
	}

	private static ArrayList<String> findPrefixes(ArrayList<String> arr, int n, ArrayList<String> resultList) {
		root = new TrieNode();
		root.freq = 0;
		for(int i = 0; i < n; i++) {
			insert(arr.get(i));
		}
		char[] prefix = new char[MAX_WORD_LENGTH];
		findPrefixUtil(root,prefix,0,resultList);
		return resultList;
	}
	
	

	private static void findPrefixUtil(TrieNode root, char[] prefix, int index, ArrayList<String> resultList) {
		if(root == null)
			return;
		if(root.freq == 1) {
			prefix[index] = '\0';
			int i = 0; 
			StringBuilder temp = new StringBuilder();
			while(prefix[i] != '\0') {
				temp.append(prefix[i++]);
			}
			resultList.add(temp.toString());
			return;
		}
		
		for(int j = 0 ; j < MAX; j++) {
			if(root.children[j] != null) {
				prefix[index] = (char)j;
				findPrefixUtil(root.children[j], prefix, index+1,resultList);
			}
		}
	}
	
	public static void main(String[] args) {
		ArrayList<String> arrList = new ArrayList<String>(Arrays.asList("zebra","dog","duck","dove"));
		ArrayList<String> resultList = new ArrayList<String>();
		int n = arrList.size();
		resultList = findPrefixes(arrList,n,resultList);
		System.out.println(resultList);
	}
	
}
