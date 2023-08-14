package luke.algorithm.practice.graph;

import java.util.ArrayList;
import java.util.HashMap;

import static luke.algorithm.practice.graph.GraphNode.State.*;

public class Graph {

    public HashMap<String, GraphNode> nodes;

    public Graph(HashMap<String, String[]> graphMap){
        nodes = new HashMap<>();
        graphMap.forEach(
                (k, v) -> {
                    GraphNode node = nodes.containsKey(k) ? nodes.get(k) : new GraphNode(k);
                    for(String name: v){
                        GraphNode linkedNode = nodes.containsKey(name) ? nodes.get(name) : new GraphNode(name);
                        nodes.put(name, linkedNode);
                        node.addLinkedNode(linkedNode);
                    }
                    nodes.put(k, node);
                }
        );
    }

    public int size(){
        return nodes.size();
    }

    public GraphNode getByName(String name){
        return nodes.get(name);
    }

    public boolean searchRoute(GraphNode start, GraphNode end){
        for (GraphNode node : nodes.values()){
            node.state = Unvisited;
        }
        ArrayList<GraphNode> queue = new ArrayList<>();
        queue.add(start);
        while(!queue.isEmpty()){
            GraphNode node = queue.remove(0);
            if (node.equals(end)){
                return true;
            }
            for(GraphNode linkedNode: node.linkedNodes){
                if (linkedNode.state == Unvisited){
                    queue.add(linkedNode);
                }
            }
            node.state = Visited;
        }

        return false;
    }
}
