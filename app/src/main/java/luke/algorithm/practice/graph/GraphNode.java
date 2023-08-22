package luke.algorithm.practice.graph;

import java.util.ArrayList;
import java.util.Objects;

public class GraphNode {
    public String name;
    public ArrayList<GraphNode> linkedNodes;

    public State state;

    enum State {Unvisited, Visited, Visiting}

    public GraphNode(String name) {
        this.name = name;
        this.linkedNodes = new ArrayList<>();
    }

    public void addLinkedNode(GraphNode linkedNode) {
        linkedNodes.add(linkedNode);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GraphNode graphNode = (GraphNode) o;
        return Objects.equals(name, graphNode.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, linkedNodes, state);
    }
}
