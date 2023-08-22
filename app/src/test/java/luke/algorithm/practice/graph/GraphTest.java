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

    @Test
    public void buildOrder1(){
        HashMap<String, String[]> map = new HashMap<>();
        map.put("a", new String[]{});
        graph = new Graph(map);
        assertArrayEquals(new String[]{"a"},graph.buildOrder().toArray());
        map = new HashMap<>();
        map.put("a", new String[]{"b"});
        graph = new Graph(map);
        assertArrayEquals(new String[]{"b", "a"},graph.buildOrder().toArray());
        map = new HashMap<>();
        map.put("a", new String[]{"b"});
        map.put("b", new String[]{"c"});
        graph = new Graph(map);
        assertArrayEquals(new String[]{"c", "b", "a"},graph.buildOrder().toArray());
        map = new HashMap<>();
        map.put("a", new String[]{"b", "c"});
        map.put("b", new String[]{"d", "e"});
        map.put("c", new String[]{"f", "g"});
        map.put("e", new String[]{"h", "i"});
        graph = new Graph(map);
        assertArrayEquals(new String[]{"g", "f", "c", "i", "h", "e", "d", "b", "a"},graph.buildOrder().toArray());
    }

    @Test
    public void buildOrder2(){
        assertNull(graph.buildOrder());
        HashMap<String, String[]> map = new HashMap<>();
        map.put("a", new String[]{"b"});
        map.put("b", new String[]{"a"});
        graph = new Graph(map);
        assertNull(graph.buildOrder());
        map = new HashMap<>();
        map.put("a", new String[]{"b"});
        map.put("b", new String[]{"c"});
        map.put("c", new String[]{"a"});
        graph = new Graph(map);
        assertNull(graph.buildOrder());
    }

    @Test
    public void buildOrder3(){
        HashMap<String, String[]> map = new HashMap<>();
        map.put("a", new String[]{"b"});
        map.put("b", new String[]{"c"});
        map.put("c", new String[]{"d"});
        map.put("d", new String[]{"b"});
        graph = new Graph(map);
        assertNull(graph.buildOrder());
    }

    @Test
    public void buildOrder4(){
        HashMap<String, String[]> map = new HashMap<>();
        map.put("a", new String[]{"b"});
        map.put("c", new String[]{"d"});
        graph = new Graph(map);
        assertArrayEquals(new String[]{"b", "a", "d", "c"},graph.buildOrder().toArray());
    }

    @Test
    public void buildOrder5(){
        HashMap<String, String[]> map = new HashMap<>();
        map.put("f", new String[]{"c", "a", "b"});
        map.put("c", new String[]{"a"});
        map.put("b", new String[]{"a", "e", "h"});
        map.put("a", new String[]{"e"});
        graph = new Graph(map);
        assertArrayEquals(new String[]{"e", "a", "h", "b", "c", "f"},graph.buildOrder().toArray());
        map = new HashMap<>();
        map.put("a", new String[]{"b", "c", "d"});
        map.put("b", new String[]{"c"});
        map.put("d", new String[]{"c", "e", "f"});
        map.put("c", new String[]{"e"});
        graph = new Graph(map);
        assertArrayEquals(new String[]{"f", "e", "c", "d", "b", "a"},graph.buildOrder().toArray());
        map = new HashMap<>();
        map.put("d", new String[]{"a"});
        map.put("b", new String[]{"f"});
        map.put("d", new String[]{"b"});
        map.put("a", new String[]{"f"});
        map.put("c", new String[]{"d"});
        graph = new Graph(map);
        assertArrayEquals(new String[]{"f", "a", "b", "d", "c"},graph.buildOrder().toArray());
    }

}