package luke.algorithm.practice.graph;

import java.util.ArrayList;

public class GraphNode {
    public String name;
    public ArrayList<GraphNode> linkedNodes;

    public State state;

    enum State { Unvisited, Visited, Visiting; }

    public GraphNode(String name){
        this.name = name;
    }

    public void addLinkedNode(GraphNode linkedNode) {
        linkedNodes.add(linkedNode);
    }
}
