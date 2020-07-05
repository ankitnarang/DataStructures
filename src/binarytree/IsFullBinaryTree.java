package binarytree;

/*
 * 
 * To check if given tree is full binary tree.
 * In Full Binary Tree, each node will have either 0 or 2 children. 
 * If any node contains single child node then full tree can not be considered as Full Binary Tree
 * 
 */

public class IsFullBinaryTree {
	
	TreeNode root;
	
	public static void main(String[] args) {
		IsFullBinaryTree tree = new IsFullBinaryTree(); 
        tree.root = new TreeNode(10); 
        tree.root.left = new TreeNode(20); 
        tree.root.right = new TreeNode(30); 
        tree.root.left.right = new TreeNode(40); 
        tree.root.left.left = new TreeNode(50); 
        tree.root.right.left = new TreeNode(60); 
        tree.root.left.left.left = new TreeNode(80); 
        tree.root.right.right = new TreeNode(70); 
        tree.root.left.left.right = new TreeNode(90); 
        tree.root.left.right.left = new TreeNode(80); 
        tree.root.left.right.right = new TreeNode(90); 
        tree.root.right.left.left = new TreeNode(80); 
        tree.root.right.left.right = new TreeNode(90); 
        tree.root.right.right.left = new TreeNode(80); 
        tree.root.right.right.right = new TreeNode(90); 
        
        if(tree.isFullBT(tree.root))
        	System.out.println("The binary tree is full");
        else
        	System.out.println("The binary tree is not full");
	}

	private boolean isFullBT(TreeNode node) {
		if(node == null)
			return true;
		
		if(node.left == null && node.right == null)
			return true;
		
		if(node.left != null && node.right != null)
			return (isFullBT(node.left) && isFullBT(node.right));
		
		return false;
	}

}
