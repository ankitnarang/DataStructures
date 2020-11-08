package binarytree;

public class MinimumHeightOfBT {
	
	TreeNode root;
	
	public static void main(String[] args) {
		MinimumHeightOfBT tree = new MinimumHeightOfBT(); 
		tree.root = new TreeNode(1); 
        tree.root.left = new TreeNode(2); 
        tree.root.right = new TreeNode(3); 
        tree.root.left.left = new TreeNode(4); 
        tree.root.left.right = new TreeNode(5); 
        tree.root.left.left.left = new TreeNode(15); 
        tree.root.right.left = new TreeNode(6); 
        tree.root.right.right = new TreeNode(7); 
        tree.root.right.left.right = new TreeNode(9); 
        tree.root.right.left.right.left = new TreeNode(13);
        System.out.println(minimumDepth(tree.root));
	}

	private static int minimumDepth(TreeNode root) {
		if(root == null)
			return 0;
		
		int lHeight = minimumDepth(root.left);
		int rHeight = minimumDepth(root.right);
		
		return Math.min(lHeight, rHeight) + 1;
	}

}
