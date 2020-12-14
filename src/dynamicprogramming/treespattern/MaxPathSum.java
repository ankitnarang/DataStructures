package dynamicprogramming.treespattern;

public class MaxPathSum {
    // Reference Link : https://www.youtube.com/watch?v=Osz-Vwer6rw&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=49&ab_channel=AdityaVerma
    // Question Link : https://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/
    public static void main(String[] args) {
        Node root = newNode(10);
        root.left = newNode(2);
        root.right = newNode(10);
        root.left.left = newNode(20);
        root.left.right = newNode(1);
        root.right.right = newNode(-25);
        root.right.right.left = newNode(3);
        root.right.right.right = newNode(4);
        findMaxPathSum(root);
        System.out.println("Max sum path of the tree has sum " + ans);
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

    static int ans = Integer.MIN_VALUE;

    private static int findMaxPathSum(Node root) {
        if(root == null){
            return 0;
        }

        int l = findMaxPathSum(root.left);
        int r = findMaxPathSum(root.right);

        int temp = Math.max(Math.max(l,r) + root.data,
                root.data);

        int answer = Math.max(temp,
                l + r + root.data);

        ans = Math.max(ans,answer);

        return temp;
    }

}
