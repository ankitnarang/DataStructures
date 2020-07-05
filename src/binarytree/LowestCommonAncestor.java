package binarytree;

import java.util.*;

/*
 * 
 * Let T be a rooted tree. The lowest common ancestor between two nodes n1 and n2 is 
 * defined as the lowest node in T that has both n1 and n2 as descendants
 * (where we allow a node to be a descendant of itself).
 * 
 */


public class LowestCommonAncestor {
	TreeNode root; 
	private List<Integer> list1 = new ArrayList<>();
	private List<Integer> list2 = new ArrayList<>();
	
	public static void main(String[] args) {
		
		LowestCommonAncestor tree = new LowestCommonAncestor();
		tree.root = new TreeNode(1); 
        tree.root.left = new TreeNode(2); 
        tree.root.right = new TreeNode(3); 
        tree.root.left.left = new TreeNode(4); 
        tree.root.left.right = new TreeNode(5); 
        tree.root.right.left = new TreeNode(6); 
        tree.root.right.right = new TreeNode(7); 
        //tree.root.right.left.right = new TreeNode(9); 
        //tree.root.right.left.right.left = new TreeNode(13);
		
		System.out.println(tree.findLCA(13,7)); // using arraylist
		System.out.println(tree.findLCAII(tree.root, 3, 15).data); // byt returning found node
	}

	private int findLCA(int n1, int n2) {
		list1.clear();
		list2.clear();
		return findLCAInternal(root,n1,n2);
	}
	
	private int findLCAInternal(TreeNode root, int n1, int n2) {
		if(!findPath(root,n1,list1) || !findPath(root,n2,list2)) {
			System.out.println((list1.size() > 0) ? n1 + " is present" : n1 + " is missing");
			System.out.println((list2.size() > 0) ? n2 + " is present" : n2 + " is missing");
			return -1;
		}
		int i;
		for(i = 0 ; i < list1.size() && i < list2.size(); i++) {
			if (!(list1.get(i).equals(list2.get(i))) )
				break;
		}
		return list1.get(i-1);
	}
	
	/*
	 * By Storing root to n1 and root to n2 paths
	 */
	private boolean findPath(TreeNode root, int n, List<Integer> list) {
		
		if(root == null)
			return false;
		
		list.add(root.data);
		
		if(root.data == n)
			return true;
		
		if(root.left != null && findPath(root.left, n, list))
			return true;
		
		if(root.right != null && findPath(root.right, n, list))
			return true;
			
		list.remove(list.size()-1);

		return false;
	}
	
	/*
	 * By returning the found node to the calling node 
	 */
	
	private TreeNode findLCAII(TreeNode root, int n1, int n2) {
		if(root == null)
			return null;
		
		if(root.data == n1 || root.data == n2)
			return root;
		
		TreeNode left_lca = findLCAII(root.left, n1, n2);
		TreeNode right_lca = findLCAII(root.right, n1, n2);
		
		if(left_lca != null && right_lca != null)
			return root;
		
		return (left_lca != null) ? left_lca : right_lca;
	}

}
