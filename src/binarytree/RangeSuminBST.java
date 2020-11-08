package binarytree;


import java.util.LinkedList;
import java.util.Queue;

public class RangeSuminBST {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        /*
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.left = null;
        root.right.right = new TreeNode(18);
        int L = 7;
        int R = 15;
        System.out.println("Sum of values between range [" + L + "," + R + "] is " + rangeSumBST(root,L,R));
        */
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(18);
        root.left.left.left = new TreeNode(1);
        root.left.left.right = null;
        root.left.right.left = new TreeNode(6);
        int L = 6;
        int R = 10;
        System.out.println("Sum of values between range [" + L + "," + R + "] is " + rangeSumBST(root,L,R));
    }

    private static int rangeSumBST(TreeNode root, int L, int R){
        if(root == null)
            return 0;

        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();

            if(temp.val >= L && temp.val <= R){
                System.out.println("temp value " + temp.val);
                sum += temp.val;
            }
            if(temp.left != null && temp.val > L){
                queue.add(temp.left);
            }
            if(temp.right != null && temp.val < R){
                queue.add(temp.right);
            }
        }
        return sum;
    }

}
