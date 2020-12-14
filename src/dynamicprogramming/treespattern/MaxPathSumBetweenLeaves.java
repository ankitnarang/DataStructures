package dynamicprogramming.treespattern;

public class MaxPathSumBetweenLeaves {
    // Reference Link : https://www.youtube.com/watch?v=ArNyupe-XH0&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=50&ab_channel=AdityaVerma
    // Question Link : https://www.techiedelight.com/find-maximum-sum-path-between-two-leaves-in-a-binary-tree/
    public static void main(String[] args) {

        Node root = newNode(10);
        root.left = newNode(2);
        root.right = newNode(10);
        root.left.left = newNode(20);
        root.left.right = newNode(1);
        root.right.right = newNode(-25);
        root.right.right.left = newNode(3);
        root.right.right.right = newNode(4);

        /*
        Node root = newNode(-15);
        root.left = newNode(5);
        root.right = newNode(6);
        root.left.left = newNode(-8);
        root.left.right = newNode(1);
        root.left.left.left = newNode(2);
        root.left.left.right = newNode(6);
        root.right.right = newNode(-25);
        root.right.left = newNode(3);
        root.right.right = newNode(9);
        root.right.right.right = newNode(0);
        root.right.right.right.left = newNode(4);
        root.right.right.right.right = newNode(-1);
        root.right.right.right.right.left = newNode(10);
        */
        findMaxPathSum(root);
        System.out.println("Max sum path between 2 leaves of the tree, sum " + result);
    }

    static class Node {
        int data;
        Node left;
        Node right;
    }

    static Node newNode(int data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.left = null;
        newNode.right = null;
        return newNode;
    }

    static int result = Integer.MIN_VALUE;

    private static int findMaxPathSum(Node root) {
        if(root == null){
            return 0;
        }

        int l = findMaxPathSum(root.left);
        int r = findMaxPathSum(root.right);

        int curr_sum = l + r + root.data;
        result = Math.max(result,curr_sum);

        if(root.left == null){
            return r + root.data;
        }

        if(root.right == null){
            return l + root.data;
        }

        return Math.max(l,r) + root.data;
    }
}
