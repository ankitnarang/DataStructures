package binarytree;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    TreeNode root;
    public static void main(String[] args) {
        PathSumII tree = new PathSumII();
        tree.root = new TreeNode(5);
        tree.root.left = new TreeNode(4);
        tree.root.right = new TreeNode(8);
        tree.root.left.left = new TreeNode(11);
        tree.root.left.left.left = new TreeNode(7);
        tree.root.left.left.right = new TreeNode(2);
        tree.root.right.left = new TreeNode(13);
        tree.root.right.right = new TreeNode(4);
        tree.root.right.right.left = new TreeNode(5);
        tree.root.right.right.right = new TreeNode(1);
        int sum = 22;
        List<List<Integer>> result  = pathSum(tree.root,sum);
        result.forEach((x) -> System.out.println(x));
    }

    private static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> paths = new ArrayList<>();
        findPaths(root,sum, new ArrayList<Integer>(), paths);
        return paths;
    }

    private static void findPaths(TreeNode root, int sum, ArrayList<Integer> current, List<List<Integer>> paths) {
        if(root == null){
            return;
        }

        current.add(root.data);
        if(root.data == sum && root.left == null && root.right == null){
            paths.add(current);
            return;
        }

        findPaths(root.left, sum - root.data, new ArrayList<>(current), paths);
        findPaths(root.right, sum - root.data, new ArrayList<>(current), paths);
    }
}
