package DSA.Tree;

import java.util.*;

class Graph{
    private final boolean[] visited;
    private final LinkedList<Integer>[] adjLists;
    private final Queue<Integer> que;
    public Graph(int vertices) {
        adjLists = new LinkedList[vertices];
        que = new LinkedList<Integer>();
        visited = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            adjLists[i] = new LinkedList<Integer>();
        }
    }
    void addEdge(int src,int dest){
        adjLists[src].add(dest);
    }
    void DFS(int vertex){
        visited[vertex] = true;
        System.out.println(vertex+" ");
        Iterator<Integer> i = adjLists[vertex].listIterator();
        while(i.hasNext()){
            int n = i.next();
            if(!visited[n]){
                DFS(n);
            }
        }
    }
    void BFS(int vertex){
        int a = 0;
        visited[vertex] = true;
        que.add(vertex);

        while(que.size() > 0){
            int n = que.poll();
            System.out.println(n+" ");

            for(int i=0;i<adjLists[vertex].size();i++){
                a = adjLists[vertex].get(i);
                if(!visited[a]){
                    visited[a] = true;
                    que.add(a);
                }
            }
        }
    }
}
public class DFS {
    public static void main(String[] args) {
        Graph g = new Graph(5);

        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        System.out.println("Following is Depth First Traversal");

//        g.DFS(0);
        g.BFS(0);
    }
}

