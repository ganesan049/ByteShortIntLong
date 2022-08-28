package DSA.Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GraphDS{
  Integer numberOfNodes;
  Map<Integer, List<Integer>> adjacentList;

  public GraphDS() {
    this.numberOfNodes = 0;
    this.adjacentList = new HashMap<>();
  }

  public void addVertex(Integer vertex){
    numberOfNodes+=1;
    adjacentList.put(vertex,new ArrayList<>());
  }

  public void addEdge(Integer vertex1, Integer vertex2){
    adjacentList.get(vertex1).add(vertex2);
    adjacentList.get(vertex2).add(vertex1);
  }

  public void showConnections(){
    adjacentList.forEach((k,v) -> {
      System.out.println(k+"-->"+v.toString());
    });
  }
}
public class Graph {
  public static void main(String[] args) {
    GraphDS myGraph = new GraphDS();
    myGraph.addVertex(0);
    myGraph.addVertex(1);
    myGraph.addVertex(2);
    myGraph.addVertex(3);
    myGraph.addVertex(4);
    myGraph.addVertex(5);
    myGraph.addVertex(6);
    myGraph.addEdge(3, 1);
    myGraph.addEdge(3, 4);
    myGraph.addEdge(4, 2);
    myGraph.addEdge(4, 5);
    myGraph.addEdge(1, 2);
    myGraph.addEdge(1, 0);
    myGraph.addEdge(0, 2);
    myGraph.addEdge(6, 5);
    myGraph.showConnections();
  }
}
