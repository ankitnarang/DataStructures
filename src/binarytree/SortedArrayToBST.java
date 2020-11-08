package binarytree;

import java.util.Arrays;

public class SortedArrayToBST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }

    public static void main(String[] args) {
        int nums[] = {-10,-3,0,5,9};
        System.out.println("Given sorted array ");
        for(int i : nums){
            System.out.print(i + " ");
        }
        System.out.println();
        TreeNode root = sortedArrayToBST(nums);
        System.out.println("After constructing tree");
        inorderTraversal(root);
    }

    private static void inorderTraversal(TreeNode root) {
        if(root == null){
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }

    private static TreeNode sortedArrayToBST(int[] nums){
        if(nums == null || nums.length == 0){
            return null;
        }

        return constructBST(nums,0,nums.length-1);
    }

    private static TreeNode constructBST(int[] nums, int left, int right) {
        if(left > right){
            return null;
        }
        int mid = left + (right - left)/2;
        TreeNode current = new TreeNode(nums[mid]);
        current.left = constructBST(nums,left,mid-1);
        current.right = constructBST(nums,mid+1,right);
        return current;
    }

}
