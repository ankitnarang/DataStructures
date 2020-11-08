package binarytree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

public class TopView {
	
	TreeNode root;
	public static void main(String[] args) {
		TopView topview = new TopView();
		topview.root = new TreeNode(1);
        topview.root.left = new TreeNode(2); 
        topview.root.right = new TreeNode(3); 
        topview.root.left.right = new TreeNode(4); 
        topview.root.left.right.right = new TreeNode(5); 
        topview.root.left.right.right.right = new TreeNode(6); 
        
        printTopView(topview.root);
	}
	private static void printTopView(TreeNode root) {
		
		class QueueObj {
			TreeNode node;
			int horizontalDistance;

			public QueueObj(TreeNode node, int horizontalDistance) {
				this.node = node;
				this.horizontalDistance = horizontalDistance;
			}
			
		}
		
		Queue<QueueObj> queue = new LinkedList<QueueObj>();
		Map<Integer,TreeNode> map = new TreeMap<>();
		queue.offer(new QueueObj(root, 0));
		
		while(!queue.isEmpty()) {
			QueueObj temp = queue.poll();
			if(!map.containsKey(temp.horizontalDistance)) {
				map.put(temp.horizontalDistance, temp.node);
			}
			if(temp.node.left != null) {
				queue.offer(new QueueObj(temp.node.left, temp.horizontalDistance - 1));
			}
			if(temp.node.right != null) {
				queue.offer(new QueueObj(temp.node.right, temp.horizontalDistance + 1));
			}
		}
		
		
		for(Entry<Integer, TreeNode> entry : map.entrySet()) {
			System.out.print(entry.getValue().data + " ");
		}
		
		
	}

}
