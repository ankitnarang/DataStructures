package binarytree;

import java.util.Stack;

public class IterativePreOrderTraversal {
	TreeNode root;
	static Stack<TreeNode> stack = new Stack<>();
	
	public static void main(String[] args) {
		IterativePostOrderTraversal tree = new IterativePostOrderTraversal();
		tree.root = new TreeNode(10);
		tree.root.left = new TreeNode(8);
		tree.root.right = new TreeNode(2);
		tree.root.left.left = new TreeNode(3);
		tree.root.left.right = new TreeNode(5);
		tree.root.right.left = new TreeNode(6);
		System.out.println("Pre order traversal of given tree (iterative approach - using 1 stack)");
		preorderTraversal(tree.root);
	}

	private static void preorderTraversal(TreeNode root) {
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode temp = stack.pop();
			System.out.print(temp.data + " ");
			if(temp.right != null)
				stack.push(temp.right);
			if(temp.left != null)
				stack.push(temp.left);
		}
	}

}
