package binarysearchtree;


/*
 * 
 * A binary search tree (BST) is a node based binary tree data structure which has the following properties.
 * The left subtree of a node contains only nodes with keys less than the node’s key.
 * The right subtree of a node contains only nodes with keys greater than the node’s key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 */

public class IsValidBST {
	
	TreeNode root;
	
	public static void main(String[] args) {
		IsValidBST tree = new IsValidBST();
		tree.root = new TreeNode(4);  
		tree.root.left = new TreeNode(2);  
		tree.root.right = new TreeNode(5);  
		tree.root.left.left = new TreeNode(1);  
		tree.root.left.right = new TreeNode(3); 
		System.out.println(tree.isValid(tree.root,null,null));
		System.out.println(tree.isValid1(tree.root,Integer.MIN_VALUE,Integer.MAX_VALUE));
	}

	private boolean isValid1(TreeNode root, int minValue, int maxValue) {
		if(root == null)
			return true;
		if(root.data <= minValue || root.data > maxValue)
			return false;
		return (isValid1(root.left,minValue,root.data)) && (isValid1(root.right, root.data, maxValue));
	}

	private boolean isValid(TreeNode root, TreeNode left, TreeNode right) {
		if(root == null)
			return true;
		if(left != null && root.data <= left.data)
			return false;
		if(right != null && root.data >= right.data)
			return false;
		return isValid(root.left, left, root) && isValid(root.right, root, right);
	}

}
