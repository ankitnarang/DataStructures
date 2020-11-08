package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
	TreeNode root;
	
	public static void main(String[] args) {
		LevelOrderTraversal tree_level = new LevelOrderTraversal();
		tree_level.root = new TreeNode(10); 
        tree_level.root.left = new TreeNode(10); 
        tree_level.root.right = new TreeNode(19); 
        tree_level.root.left.left = new TreeNode(-5); 
        tree_level.root.right.left = new TreeNode(17); 
        tree_level.root.right.right = new TreeNode(21); 
        System.out.println("------------------");
        tree_level.traversal(tree_level.root);
        System.out.println("\n------------------");
        tree_level.traversalLevelByLevel(tree_level.root);
        System.out.println("\n------------------");
        tree_level.levelTraversalUsingLevelCount(tree_level.root);
        System.out.println("------------------");
	}

	private void traversal(TreeNode root) {
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
	}
	
	private void traversalLevelByLevel(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		queue.offer(null);
		TreeNode p;
		while(!queue.isEmpty()) {
			p = queue.poll();
			if(p != null) {
				System.out.print(p.data + " ");
				if(p.left != null) {
					queue.add(p.left);
				}
				if(p.right != null) {
					queue.add(p.right);
				}
			} else {
				if(!queue.isEmpty()) {
					System.out.println("");
					queue.offer(null);
				}	
			}
		}
	}
	
	private void levelTraversalUsingLevelCount(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		int levelCount = 1;
		int currentCount = 0;
		queue.offer(root);
		while(!queue.isEmpty()) {
			while(levelCount > 0) {
				TreeNode temp = queue.poll();
				System.out.print(temp.data + " ");
				if(temp.left != null) {
					currentCount++;
					queue.offer(temp.left);
				}
				if(temp.right != null) {
					currentCount++;
					queue.offer(temp.right);
				}
				levelCount--;
			}
			System.out.println();
			levelCount= currentCount;
			currentCount = 0;
		}
	}
	
}
