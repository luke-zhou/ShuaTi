package luke.algorithm.practice.graph;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

    public ArrayList<GraphNode> nodes;

    public Graph(HashMap<String, String[]> graphMap){
        HashMap<String, GraphNode> nodeMap = new HashMap<>();
        graphMap.forEach(
                (k, v) -> {
                    GraphNode node = nodeMap.containsKey(k) ? nodeMap.get(k) : new GraphNode(k);
                    nodeMap.put(k, node);
                    for(String name: v){
                        GraphNode linkedNode = nodeMap.containsKey(name) ? nodeMap.get(name) : new GraphNode(name);
                        node.addLinkedNode(linkedNode);
                        nodeMap.put(name, linkedNode);
                    }
                    nodes.add(node);
                }
        );
    }
}
