package binarysearchtree;

import binarytree.LowestCommonAncestor;

public class LCAOfBST {

    TreeNode root;

    public static void main(String[] args) {
        LCAOfBST obj = new LCAOfBST();
        obj.root = new TreeNode(20);
        obj.root.left = new TreeNode(8);
        obj.root.right = new TreeNode(22);
        obj.root.left.left = new TreeNode(4);
        obj.root.left.right = new TreeNode(12);
        obj.root.left.right.left = new TreeNode(10);
        obj.root.left.right.right = new TreeNode(14);
        int num1 = 10, num2 = 14;
        TreeNode resultingNode = obj.findLCA(obj.root,num1,num2);
        System.out.println("LCA of " + num1 + " and " + num2 + " is " + resultingNode.data);

        num1 = 14;
        num2 = 8;
        resultingNode = obj.findLCA(obj.root,num1,num2);
        System.out.println("LCA of " + num1 + " and " + num2 + " is " + resultingNode.data);

        num1 = 10;
        num2 = 22;
        resultingNode = obj.findLCA(obj.root,num1,num2);
        System.out.println("LCA of " + num1 + " and " + num2 + " is " + resultingNode.data);
    }

    private TreeNode findLCA(TreeNode node, int num1, int num2) {
        if(node == null){
            return null;
        }

        if(node.data > num1 && node.data > num2){
            return findLCA(node.left,num1,num2);
        }

        if(node.data < num1 && node.data < num2){
            return findLCA(node.right,num1,num2);
        }

        return node;
    }

}
