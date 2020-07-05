package binarytree;

import java.util.Stack;

public class IterativePostOrderTraversal {
	TreeNode root;
	static Stack<TreeNode> stack1 = new Stack<>();
	static Stack<TreeNode> stack2 = new Stack<>();
	
	public static void main(String[] args) {
		IterativePostOrderTraversal tree = new IterativePostOrderTraversal();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		tree.root.right.left = new TreeNode(6);
		tree.root.right.right = new TreeNode(7);
		System.out.println("Post order traversal of given tree (iterative approach - using 2 stacks)");
		postorderTraversal(tree.root);
	}
	
	
	
	private static void postorderTraversal(TreeNode root) {
		if(root == null)
			System.out.println("Tree is empty");
		
		stack1.push(root);
		
		while(!stack1.isEmpty()) {
			TreeNode temp = stack1.pop();
			stack2.push(temp);
			if(temp.left != null) {
				stack1.push(temp.left);
			}
			if(temp.right != null) {
				stack1.push(temp.right);
			}
		}
		while(!stack2.isEmpty()) {
			System.out.print(stack2.pop().data + " ");
		}
	}

}
