package binarytree;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 
 * Flip the Binary Tree so that leftmost node of the Tree will become root.
 * 
 */


public class FlipBinaryTree {
	
	TreeNode root;
	
	public static void main(String[] args) {
		FlipBinaryTree tree = new FlipBinaryTree();
		tree.root = new TreeNode(1);
		tree.root.left=new TreeNode(2); 
        tree.root.right=new TreeNode(3); 
        tree.root.right.left = new TreeNode(4);  
        tree.root.right.right = new TreeNode(5);  
        System.out.println("Level order traversal of given tree"); 
        printLevelOrder(tree.root);  
        
        tree.root = flipBinaryTree(tree.root);
        System.out.println("Level order traversal of given tree"); 
        printLevelOrder(tree.root);
        
	}

	private static TreeNode flipBinaryTree(TreeNode root) {
		if(root == null)
			return root;
		if(root.left == null && root.right == null)
			return root;
		
		TreeNode flippedRoot = flipBinaryTree(root.left);
		
		root.left.left = root.right;
		root.left.right = root;
		root.left = null;
		root.right = null;

		return flippedRoot;
	}

	private static void printLevelOrder(TreeNode root) {
		if(root == null)
			return;
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			System.out.print(temp.data + " ");
			if(temp.left != null)
				queue.add(temp.left);
			if(temp.right != null)
				queue.add(temp.right);
		}
		System.out.println();
	}

}
