package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class MirrorBinaryTree {
		TreeNode root;
	
	public static void main(String[] args) {
		MirrorBinaryTree tree = new MirrorBinaryTree();
		tree.root = new TreeNode(1); 
        tree.root.left = new TreeNode(3); 
        tree.root.right = new TreeNode(2); 
        tree.root.right.left = new TreeNode(5);
        tree.root.right.right = new TreeNode(4); 
        System.out.println("Level order traversal of given tree"); 
        printLevelOrder(tree.root);  
        
        tree.root = mirror(tree.root);
        System.out.println("Level order traversal of given tree"); 
        printLevelOrder(tree.root);
	}

	private static TreeNode mirror(TreeNode node) {
		if(node == null)
			return node;
		
		TreeNode left = mirror(node.left);
		TreeNode right = mirror(node.right);
		
		node.left = right;
		node.right = left;
		
		return node;
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
