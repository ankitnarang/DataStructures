package binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NodeAtDistanceK {
	
	TreeNode root;
	
	public static void main(String[] args) {
		NodeAtDistanceK tree = new NodeAtDistanceK();
			
		tree.root = new TreeNode(20);
		tree.root.left=new TreeNode(8); 
        tree.root.right=new TreeNode(22); 
        tree.root.right.left = new TreeNode(5);  
        tree.root.right.right = new TreeNode(8);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.left.left = new TreeNode(25);
        tree.root.left.right = new TreeNode(12);
        tree.root.left.right.left = new TreeNode(10);
        tree.root.left.right.left.left = new TreeNode(15);
        tree.root.left.right.left.right = new TreeNode(18);
        tree.root.left.right.left.right.right = new TreeNode(23);
        tree.root.left.right.right = new TreeNode(14);
        
        TreeNode target = tree.root.left.right;
        int k = 3;
        List<Integer> result = distanceK(tree.root,target,k);
        System.out.println("Node at distance k are "  + result);
	}

	private static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		List<Integer> ans = new ArrayList<>();
		Map<TreeNode,TreeNode> parents = new HashMap<>();
		makeParents(root,parents);
		Set<TreeNode> visited = new HashSet<>();
		dfs(target,k,parents,visited,ans);
		return ans;
	}

	private static void dfs(TreeNode curr, int k, Map<TreeNode, TreeNode> parents, Set<TreeNode> visited,
			List<Integer> soFar) {
		if(curr == null)
			return;
		if(k == 0) {
			soFar.add(curr.data);
			return;
		}
		visited.add(curr);
		
		if(curr.left != null && !visited.contains(curr.left)) {
			dfs(curr.left,k-1,parents,visited,soFar);
		}
		
		if(curr.right != null && !visited.contains(curr.right)) {
			dfs(curr.right,k-1,parents,visited,soFar);
		}
		
		if(parents.containsKey(curr) && !visited.contains(parents.get(curr))) {
			dfs(parents.get(curr), k-1, parents, visited, soFar);
		}
		
		visited.remove(curr);
			
	}

	private static void makeParents(TreeNode root, Map<TreeNode, TreeNode> parents) {
		if(root == null)
			return;
		if(root.left != null)
			parents.put(root.left, root);
		if(root.right != null)
			parents.put(root.right, root);
		
		makeParents(root.left, parents);
		makeParents(root.right, parents);
	}

}
