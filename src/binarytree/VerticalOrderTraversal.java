package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrderTraversal {
	TreeNodeVOT root;
	TreeMap<Integer,ArrayList<Integer>> map = new TreeMap<>();
	
	public static void main(String[] args) {
		VerticalOrderTraversal tree_level = new VerticalOrderTraversal(); 
		tree_level.root = new TreeNodeVOT(10); 
        tree_level.root.left = new TreeNodeVOT(70); 
        tree_level.root.right = new TreeNodeVOT(19); 
        tree_level.root.left.left = new TreeNodeVOT(-5); 
        tree_level.root.left.right = new TreeNodeVOT(-15); 
        tree_level.root.left.left.left = new TreeNodeVOT(34);
        tree_level.root.left.left.right = new TreeNodeVOT(6);
        tree_level.root.left.left.right.left = new TreeNodeVOT(45);
        tree_level.root.left.left.right.right = new TreeNodeVOT(89);
        tree_level.root.right.left = new TreeNodeVOT(111); 
        tree_level.root.right.right = new TreeNodeVOT(87);
        tree_level.root.right.left.left = new TreeNodeVOT(67); 
        tree_level.root.right.left.right = new TreeNodeVOT(23); 
        tree_level.root.right.left.right.left = new TreeNodeVOT(75); 
        tree_level.root.right.left.right.right = new TreeNodeVOT(43); 
        tree_level.root.right.right.right = new TreeNodeVOT(101);
        
        tree_level.solve(tree_level.root);
	}
	
	private void solve(TreeNodeVOT root) {
		Queue<TreeNodeVOT> queue = new LinkedList<>();
		queue.offer(root);
		root.horizontalDistance = 0;
		ArrayList<Integer> list = new ArrayList<>();
		list.add(root.val);
		map.put(0, list);
		while(!queue.isEmpty()) {
			TreeNodeVOT temp = queue.poll();
			if(temp.left != null) {
				temp.left.horizontalDistance = temp.horizontalDistance - 1;
				queue.offer(temp.left);
				if(map.containsKey(temp.left.horizontalDistance)) {
					map.get(temp.left.horizontalDistance).add(temp.left.val);
				} else {
					list = new ArrayList<Integer>();
					list.add(temp.left.val);
					map.put(temp.left.horizontalDistance, list);
				}
			}
			if(temp.right != null) {
				temp.right.horizontalDistance = temp.horizontalDistance + 1;
				queue.offer(temp.right);
				if(map.containsKey(temp.right.horizontalDistance)) {
					map.get(temp.right.horizontalDistance).add(temp.right.val);
				} else {
					list = new ArrayList<Integer>();
					list.add(temp.right.val);
					map.put(temp.right.horizontalDistance, list);
				}
			}
		}
		for(Entry<Integer,ArrayList<Integer>> entry : map.entrySet()) {
			System.out.println(entry.getValue());
		}
	}
	
	
	

}
class TreeNodeVOT{
	int val;
	int horizontalDistance;
	TreeNodeVOT left;
	TreeNodeVOT right;
	
	public TreeNodeVOT(int val) {
		this.val = val;
		this.left = this.right = null;
	}
	
}
