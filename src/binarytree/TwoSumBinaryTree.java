package binarytree;

import java.util.ArrayList;

public class TwoSumBinaryTree {
	TreeNode root;
	
	public TwoSumBinaryTree() {
		root = null;
	}
	
	public static void main(String[] args) {
		TwoSumBinaryTree tree = new TwoSumBinaryTree();
		tree.insert(15); 
        tree.insert(10); 
        tree.insert(20); 
        tree.insert(8); 
        tree.insert(12); 
        tree.insert(16); 
        tree.insert(25); 
        
        int target = 29;
        System.out.println(tree.isPairPresent(tree.root,target));
	}
	
	private void insert(int data) {
		root = inserRecur(root,data);
	}
	
	private TreeNode inserRecur(TreeNode root, int data) {
		if(root == null) {
			root = new TreeNode(data);
			return root;
		}
		
		if(data < root.data) { 
			root.left = inserRecur(root.left, data);
		} else if(data > root.data) { 
			root.right = inserRecur(root.right, data);
		}
			
		return root;
	}

	private boolean isPairPresent(TreeNode root, int target) {
		ArrayList<Integer> res1 = new ArrayList<>();
		//ArrayList<Integer> res2 = treeToList(root,res1);
		treeToList(root,res1);
		
		int start = 0;
		int end = res1.size() - 1;
		
		while(start < end) {
			int sum = res1.get(start) + res1.get(end);
			if(sum == target) {
				System.out.println("res1.get(start) " + res1.get(start) + " res1.get(end) " + res1.get(end));
				return true;
			}
			else if(sum > target)
				end--;
			else 
				start++;
		}
		
		return false;
	}

	private void treeToList(TreeNode root, ArrayList<Integer> list) {
		if(root == null)
			return;
		
		treeToList(root.left, list);
		list.add(root.data);
		treeToList(root.right, list);
	}

}
