package dynamicprogramming.treespattern;

public class DiameterOfBinaryTree {
    // Reference Link : https://www.youtube.com/watch?v=zmPj_Ee3B8c&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=48&ab_channel=AdityaVerma
    // Question Link : https://leetcode.com/problems/diameter-of-binary-tree/solution/
    public static void main(String[] args) {
        Node root = newNode(1);
        root.left = newNode(2);
        root.right = newNode(3);
        root.left.left = newNode(4);
        root.right.right = newNode(5);
        diameter(root);
        System.out.println("Diameter of the tree is " + (ans-1));
    }

    static class Node {
        int data;
        Node left, right;
    }

    static Node newNode(int data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.left = null;
        newNode.right = null;
        return newNode;
    }

    static int ans = 1;

    static int diameter(Node root) {
        if (root == null) {
            return 0;
        }

        int left = diameter(root.left);
        int right = diameter(root.right);

        int temp = Math.max(left, right) + 1;
        ans = Math.max(ans, 1 + left + right);

        return temp;
    }
}