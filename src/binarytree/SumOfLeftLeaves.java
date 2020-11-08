package binarytree;

public class SumOfLeftLeaves {

    TreeNode root;

    public static void main(String[] args) {
        SumOfLeftLeaves obj = new SumOfLeftLeaves();
        obj.root = new TreeNode(3);
        obj.root.left = new TreeNode(9);
        obj.root.left.left = new TreeNode(19);
        obj.root.left.right = new TreeNode(49);
        obj.root.left.right.left = new TreeNode(30);
        obj.root.right = new TreeNode(20);
        obj.root.right.left = new TreeNode(15);
        obj.root.right.left.left = new TreeNode(75);
        obj.root.right.left.right = new TreeNode(65);
        obj.root.right.right = new TreeNode(7);
        int sum = sum(obj.root);
        System.out.println("Sum of left leaves is " + sum);
    }

    private static int sum(TreeNode root) {
        if(root == null){
            return 0;
        } else if(root.left != null && root.left.left == null && root.left.right == null){
            return root.left.data + sum(root.right);
        } else {
            return sum(root.left) + sum(root.right);
        }
    }

}
