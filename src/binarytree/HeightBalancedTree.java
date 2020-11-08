package binarytree;

/*
 * 
 * Height Balanced Tree is tree where each node satisfies following condition
 * At every node, Height of Left Sub Tree - Height of Right Sub Tree = -1 , 0 or 1.
 * 
 */

public class HeightBalancedTree {
	
	TreeNode root;
	
	public static void main(String[] args) {
		HeightBalancedTree tree = new HeightBalancedTree();
		tree.root = new TreeNode(1); 
        tree.root.left = new TreeNode(2); 
        tree.root.right = new TreeNode(3); 
        tree.root.left.left = new TreeNode(4); 
        tree.root.left.right = new TreeNode(5); 
        tree.root.left.left.left = new TreeNode(8); 
		
        if(tree.isHeightBalanced(tree.root))
        	System.out.println("Tree is balanced");
        else
        	System.out.println("Tree is not balanced");
        
	}

	private boolean isHeightBalanced(TreeNode root) {
		if(root == null)
			return true;
		int lHeight = height(root.left);
		int rHeight = height(root.right);
		
		if((Math.abs(lHeight - rHeight) <= 1) && isHeightBalanced(root.left) && isHeightBalanced(root.right))
			return true;
		
		return false;
	}

	private int height(TreeNode root) {
		if(root == null)
			return 0;
		return Math.max(height(root.left),height(root.right)) + 1;
	}

}
