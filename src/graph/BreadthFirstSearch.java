package graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
    private int V;
    private LinkedList<Integer> adj[];

    BreadthFirstSearch(int v){
        this.V = v;
        adj = new LinkedList[v];
        for(int i = 0; i < v; i++){
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w){
        adj[v].add(w);
    }

    public void bfs(int s) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[this.V];
        queue.add(s);
        visited[s] = true;
        while(queue.size() != 0){
            s = queue.poll();
            System.out.print(s + " ");
            Iterator<Integer> itr = adj[s].listIterator();
            while(itr.hasNext()){
                int n = itr.next();
                if(!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        BreadthFirstSearch obj = new BreadthFirstSearch(4);
        obj.addEdge(0, 1);
        obj.addEdge(0, 2);
        obj.addEdge(1, 2);
        obj.addEdge(2, 0);
        obj.addEdge(2, 3);
        obj.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal, starting with vertex 2 ");
        obj.bfs(2);
    }
}
