package luke.algorithm.practice.graph;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Set;

import static org.junit.Assert.*;

public class GraphTest {

    private Graph graph;
    private GraphNode nodeA;
    private GraphNode nodeB;
    private GraphNode nodeC;
    private GraphNode nodeD;
    private GraphNode nodeE;

    @Before
    public void setUp() throws Exception {
        HashMap<String, String[]> map = new HashMap<>();
        String[] aa = {"b", "c"};
        map.put("a", aa);
        String[] bb = {"a", "c", "e"};
        map.put("b", bb);
        String[] cc = {"d"};
        map.put("c", cc);
        String[] dd = {"b", "e"};
        map.put("d", dd);
        String[] ee = {};
        map.put("e", ee);

        graph = new Graph(map);
        nodeA = graph.getByName("a");
        nodeB = graph.getByName("b");
        nodeC = graph.getByName("c");
        nodeD = graph.getByName("d");
        nodeE = graph.getByName("e");
    }

    @Test
    public void constructorTest() {
        assertEquals(5, graph.size());
        nodeA = graph.getByName("a");
        nodeB = graph.getByName("b");
        nodeC = graph.getByName("c");
        nodeD = graph.getByName("d");
        nodeE = graph.getByName("e");
        assertEquals(2, nodeA.linkedNodes.size());
        assertEquals(3, nodeB.linkedNodes.size());
        assertEquals(1, nodeC.linkedNodes.size());
        assertEquals(2, nodeD.linkedNodes.size());
        assertEquals(0, nodeE.linkedNodes.size());
    }

    @Test
    public void searchRouteTest1() {
        assertTrue(graph.searchRoute(nodeA, nodeE));
        assertTrue(graph.searchRoute(nodeB, nodeE));
        assertTrue(graph.searchRoute(nodeC, nodeE));
        assertTrue(graph.searchRoute(nodeD, nodeE));
        assertFalse(graph.searchRoute(nodeE, nodeA));
        assertFalse(graph.searchRoute(nodeE, nodeB));
        assertFalse(graph.searchRoute(nodeE, nodeC));
        assertFalse(graph.searchRoute(nodeE, nodeD));
    }

}