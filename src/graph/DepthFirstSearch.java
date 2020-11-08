package graph;

import java.util.Iterator;
import java.util.LinkedList;

public class DepthFirstSearch {
    private int V;
    private LinkedList<Integer> adj[];

    DepthFirstSearch(int v){
            this.V = v;
            adj = new LinkedList[v];
            for(int i = 0; i < v; i++){
                adj[i] = new LinkedList<>();
            }
    }

    void addEdge(int v, int w){
        adj[v].add(w);
    }

    void dfs(int s){
        boolean[] visited = new boolean[this.V];
        dfsUtil(s,visited);
    }

    private void dfsUtil(int s, boolean[] visited){
        visited[s] = true;
        System.out.print(s + " ");
        Iterator itr = adj[s].listIterator();
        while (itr.hasNext()){
            int n = (int)itr.next();
            if(!visited[n]){
                dfsUtil(n,visited);
            }
        }
    }

    public static  void main(String[] args){
        DepthFirstSearch obj = new DepthFirstSearch(4);
        obj.addEdge(0, 1);
        obj.addEdge(0, 2);
        obj.addEdge(1, 2);
        obj.addEdge(2, 0);
        obj.addEdge(2, 3);
        obj.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal(starting from vertex 2)");

        obj.dfs(2);

    }

}
