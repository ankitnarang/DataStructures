package binarytree;

public class Symmetric {
    TreeNode root;
    public static void main(String[] args) {
        Symmetric tree = new Symmetric();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(2);
        tree.root.left.right = new TreeNode(3);
        tree.root.right.right = new TreeNode(3);
        System.out.println(isSymmetric(tree.root));
    }

    private static boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }

        return isSymmetric(root.left,root.right);
    }

    private static boolean isSymmetric(TreeNode root1,TreeNode root2) {
        if(root1 == null || root2 == null){
            return root1 == null && root2 == null;
        }
        if(root1.data != root2.data){
            return false;
        }

        return isSymmetric(root1.left,root2.right) && isSymmetric(root1.right,root2.left);
    }
}
