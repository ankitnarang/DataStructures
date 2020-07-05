package binarytree;

public class RightView {
	TreeNode root;
	static int maxLevel = 0;
	
	public static void main(String[] args) {
		RightView tree = new RightView();
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
        
        tree.printRightView(tree.root,1);
	}

	private void printRightView(TreeNode root, int level) {
		if(root == null)
			return;
		if(level > maxLevel) {
			System.out.print(root.data + " ");
			maxLevel = level;
		}
		
		printRightView(root.right, level + 1);
		printRightView(root.left, level + 1);
		
	}

}
