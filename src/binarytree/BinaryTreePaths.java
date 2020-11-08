package binarytree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

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
        BinaryTreePaths.TreeNode root = new TreeNode(10);
        root.left = new TreeNode(25);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(17);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(28);
        root.left.left.left = new TreeNode(1);
        root.left.left.right = null;
        root.left.right.left = new TreeNode(6);

        System.out.println("The paths from root to leaf are " + paths(root));

    }

    private static List<String> paths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if(root == null)
            return paths;
        dfs(root,"",paths);
        return  paths;
    }

    private static void dfs(TreeNode root, String path, List<String> paths) {
        path += root.val;
        if(root.left == null && root.right == null){
            paths.add(path);
            return;
        }
        if(root.left != null){
            dfs(root.left,path + "->",paths);
        }
        if(root.right != null){
            dfs(root.right,path + "->",paths);
        }
    }

}

