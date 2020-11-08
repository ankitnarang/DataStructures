package binarytree;

public class RootToLeafSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.right = new TreeNode(1);
        int sum = 22; // 23
        System.out.println("Does tree has path sum " + sum + " ? " + hasPathSum(root,sum));
    }

    private static boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        } else if(root.left == null && root.right == null && ((sum - root.data) == 0)){
            return true;
        } else {
            return hasPathSum(root.left,sum-root.data) ||
                    hasPathSum(root.right,sum-root.data);
        }
    }
}
