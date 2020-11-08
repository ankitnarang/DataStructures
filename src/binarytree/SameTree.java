package binarytree;

public class SameTree {
    TreeNode root1;
    TreeNode root2;
    public static void main(String[] args) {
        SameTree obj = new SameTree();
        obj.root1 = new TreeNode(1);
        obj.root1.left = new TreeNode(2);
        obj.root1.right = new TreeNode(3);
        obj.root1.right.left = new TreeNode(4);

        obj.root2 = new TreeNode(1);
        obj.root2.left = new TreeNode(2);
        obj.root2.right = new TreeNode(3);

        boolean result = isSameTree(obj.root1,obj.root2);
        System.out.println("Are both trees same? " + result);
    }

    private static boolean isSameTree(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null){
            return true;
        } else if(root1 == null || root2 == null){
            return false;
        } else if(root1.data != root2.data){
            return false;
        } else {
            return isSameTree(root1.left,root2.left) && isSameTree(root1.right,root2.right);
        }
    }


}
