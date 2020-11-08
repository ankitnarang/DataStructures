package binarytree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

public class BottomView {
	static Map<Integer,Integer> map = new TreeMap<>();
	public static void main(String[] args) {
		TreeNodeForBV root = new TreeNodeForBV(20);
		root.left = new TreeNodeForBV(8); 
        root.right = new TreeNodeForBV(22); 
        root.left.left = new TreeNodeForBV(5); 
        root.left.right = new TreeNodeForBV(3); 
        root.right.left = new TreeNodeForBV(4); 
        root.right.right = new TreeNodeForBV(25); 
        root.left.right.left = new TreeNodeForBV(10); 
        root.left.right.right = new TreeNodeForBV(14); 
        printBottomView(root);
	}

	private static void printBottomView(TreeNodeForBV root) {
		Queue<TreeNodeForBV> queue = new LinkedList<>();
		root.horiontalDistance = 0;
		queue.offer(root);
		map.put(0, root.data);
		while(!queue.isEmpty()) {
			TreeNodeForBV temp = queue.poll();
			int horizontalDistance = temp.horiontalDistance;
			map.put(horizontalDistance, temp.data);
			if(temp.left != null) {
				temp.left.horiontalDistance = temp.horiontalDistance - 1;
				queue.offer(temp.left);
			}
			if(temp.right != null) {
				temp.right.horiontalDistance = temp.horiontalDistance + 1;
				queue.offer(temp.right);
			}
		}
		
		for(Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.print(entry.getValue() + " ");
		}
	}
	
}
class TreeNodeForBV {
	int data;
	int horiontalDistance;
	TreeNodeForBV left;
	TreeNodeForBV right;
	
	public TreeNodeForBV(int data) {
		this.data = data;
		this.left = this.right = null;
		this.horiontalDistance = Integer.MAX_VALUE;
	}
}
