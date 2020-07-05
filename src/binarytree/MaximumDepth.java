package binarytree;


/*
 * 
 * Given a binary tree, find height of it. 
 * Height of empty tree is 0
 * 
 */
public class MaximumDepth {
	
	TreeNode root;
	
	public static void main(String[] args) {
		MaximumDepth tree = new MaximumDepth();
		tree.root = new TreeNode(1); 
        tree.root.left = new TreeNode(2); 
        tree.root.right = new TreeNode(3); 
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5); 
        tree.root.right.left = new TreeNode(6); 
        tree.root.right.right = new TreeNode(7); 
        tree.root.right.left.right = new TreeNode(9); 
        tree.root.right.left.right.left = new TreeNode(13);
        System.out.println(tree.maxDepth(tree.root));
	}

	private int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		
		int leftHeight = maxDepth(root.left);
		int rightHeight = maxDepth(root.right);
		
		if(leftHeight > rightHeight)
			return leftHeight + 1;
		else
			return rightHeight + 1;
		
	}
}
