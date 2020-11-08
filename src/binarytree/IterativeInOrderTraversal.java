package binarytree;

import java.util.Stack;

public class IterativeInOrderTraversal {
	TreeNode root;
	static Stack<TreeNode> stack = new Stack<>();
	
	public static void main(String[] args) {
		IterativeInOrderTraversal tree = new IterativeInOrderTraversal();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		System.out.println("In order traversal of given tree (iterative approach - using 1 stack)");
		inorderTraversal(tree.root);
	}

	private static void inorderTraversal(TreeNode root) {
		TreeNode curr = root;
		while(curr != null || !stack.isEmpty()) {
			while(curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			curr = stack.pop();
			System.out.print(curr.data + " ");
			curr = curr.right;
		}
	}

}
