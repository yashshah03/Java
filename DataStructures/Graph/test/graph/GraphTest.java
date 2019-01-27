package graph;

import customexception.CustomException;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Yash Shah
 */
public class GraphTest 
{    
    /**
     * Test of addUnidirectionalEdge method, of class Graph.
     */
    @Test
    public void testAddUnidirectionalEdge_String_String() 
    {
        System.out.println("addUnidirectionalEdge");
        Graph instance = new Graph();
        ArrayList<String> list = new ArrayList(Arrays.asList("A-B",
                                                             "A-C",
                                                             "A-D",
                                                             "D-A",
                                                             "B-F",
                                                             "C-E",
                                                             "E-F",
                                                             "D-F"));
        list.forEach((w) -> {
            String[] places = w.split("-");
            try 
            {
                instance.addUnidirectionalEdge(places[0], places[1]);
                assertEquals(true, instance.edgeExists(places[0], places[1]));
            } 
            catch (CustomException ex) 
            {
                System.err.println("testAddUnidirectionalEdge_String_String:" + ex.getMessage());
            }
        });
    }

    /**
     * Test of addUnidirectionalEdge method, of class Graph.
     */
    @Test
    public void testAddUnidirectionalEdge_3args() 
    {
        System.out.println("addUnidirectionalEdge");
        Graph instance = new Graph();
        ArrayList<String> list = new ArrayList(Arrays.asList("A-B-2",
                                                             "A-C-3",
                                                             "A-D-4",
                                                             "D-A-5",
                                                             "B-F-6",
                                                             "C-E-7",
                                                             "E-F-8",
                                                             "D-F-9"));
        list.forEach((w) -> {
            String[] places = w.split("-");
            try 
            {
                instance.addUnidirectionalEdge(places[0],
                                               places[1],
                                               Integer.parseInt(places[2]));
                assertEquals(true, instance.edgeExists(places[0], 
                                                       places[1], 
                                                       Integer.parseInt(places[2])));
            } 
            catch (CustomException ex) 
            {
                System.err.println("testAddUnidirectionalEdge_3args: " + ex.getMessage());
            }
        });
    }

    /**
     * Test of addBidirectionalEdge method, of class Graph.
     */
    @Test
    public void testAddBidirectionalEdge_String_String() 
    {
        System.out.println("addBidirectionalEdge");
        Graph instance = new Graph();
        ArrayList<String> list = new ArrayList(Arrays.asList("A-B",
                                                             "A-C",
                                                             "A-D",
                                                             "D-A",
                                                             "B-F",
                                                             "C-E",
                                                             "E-F",
                                                             "D-F"));
        list.forEach((w) -> {
            String[] places = w.split("-");
            try 
            {
                instance.addBidirectionalEdge(places[0], places[1]);
                assertEquals(true, instance.edgeExists(places[0], places[1]));
                assertEquals(true, instance.edgeExists(places[1], places[0]));
            } 
            catch (CustomException ex) 
            {
                System.err.println("testAddBidirectionalEdge_String_String: " + ex.getMessage());
            }
        });
    }

    /**
     * Test of addBidirectionalEdge method, of class Graph.
     */
    @Test
    public void testAddBidirectionalEdge_3args() 
    {
        System.out.println("addBidirectionalEdge");
        Graph instance = new Graph();
        ArrayList<String> list = new ArrayList(Arrays.asList("A-B-2",
                                                             "A-C-3",
                                                             "A-D-4",
                                                             "D-A-5",
                                                             "B-F-6",
                                                             "C-E-7",
                                                             "E-F-8",
                                                             "D-F-9"));
        list.forEach((w) -> {
            String[] places = w.split("-");
            try 
            {
                instance.addBidirectionalEdge(places[0], 
                                              places[1], 
                                              Integer.parseInt(places[2]));
                // assert
                assertEquals(true, instance.edgeExists(places[0], 
                                                       places[1], 
                                                       Integer.parseInt(places[2])));
                assertEquals(true, instance.edgeExists(places[1], 
                                                       places[0], 
                                                       Integer.parseInt(places[2])));
            } 
            catch (CustomException ex) 
            {
                System.err.println("testAddBidirectionalEdge_3args: " + ex.getMessage());
            }
        });
    }
    
    /**
     * Test of changeUniDirectionalEdgeWeight method, of class Graph.
     */
    @Test
    public void testChangeUniDirectionalEdgeWeight() 
    {
        System.out.println("removeUniDirectionalEdge");
        Graph instance = new Graph();
        ArrayList<String> list = new ArrayList(Arrays.asList("A-B-2",
                                                             "A-C-3",
                                                             "A-D-4",
                                                             "D-A-5",
                                                             "B-F-6",
                                                             "C-E-7",
                                                             "E-F-8",
                                                             "D-F-9"));
        list.forEach((w) -> {
            String[] places = w.split("-");
            try 
            {
                instance.addUnidirectionalEdge(places[0],
                                               places[1],
                                               Integer.parseInt(places[2]));
                instance.changeUniDirectionalEdgeWeight(places[0], 
                                                       places[1], 
                                                       Integer.parseInt(places[2]) + 1);
                assertEquals(true, instance.edgeExists(places[0], 
                                                       places[1], 
                                                       Integer.parseInt(places[2]) + 1));
            } 
            catch (CustomException ex) 
            {
                System.err.println("testChangeUniDirectionalEdgeWeight: " + ex.getMessage());
            }
        });
    }
    
    /**
     * Test of changeBiDirectionalEdgeWeight method, of class Graph.
     */
    @Test
    public void testChangeBiDirectionalEdgeWeight() 
    {
        System.out.println("removeUniDirectionalEdge");
        Graph instance = new Graph();
        ArrayList<String> list = new ArrayList(Arrays.asList("A-B-2",
                                                             "A-C-3",
                                                             "A-D-4",
                                                             "D-A-5",
                                                             "B-F-6",
                                                             "C-E-7",
                                                             "E-F-8",
                                                             "D-F-9"));
        list.forEach((w) -> {
            String[] places = w.split("-");
            try 
            {
                instance.addBidirectionalEdge(places[0], 
                                              places[1], 
                                              Integer.parseInt(places[2]));
                instance.changeBiDirectionalEdgeWeight(places[0], 
                                                       places[1], 
                                                       Integer.parseInt(places[2]) + 1);
                // assert
                assertEquals(true, instance.edgeExists(places[0], 
                                                       places[1], 
                                                       Integer.parseInt(places[2]) + 1));
                assertEquals(true, instance.edgeExists(places[1], 
                                                       places[0], 
                                                       Integer.parseInt(places[2]) + 1));
            } 
            catch (CustomException ex) 
            {
                System.err.println("testChangeBiDirectionalEdgeWeight: " + ex.getMessage());
            }
        });
    }

    /**
     * Test of removeUniDirectionalEdge method, of class Graph.
     */
    @Test
    public void testRemoveUniDirectionalEdge() 
    {
        System.out.println("removeUniDirectionalEdge");
        Graph instance = new Graph();
        ArrayList<String> list = new ArrayList(Arrays.asList("A-B",
                                                             "A-C",
                                                             "A-D",
                                                             "D-A",
                                                             "B-F",
                                                             "C-E",
                                                             "E-F",
                                                             "D-F"));
        list.forEach((w) -> {
            String[] places = w.split("-");
            try 
            {
                instance.addUnidirectionalEdge(places[0], places[1]);
                instance.removeUniDirectionalEdge(places[0], places[1]);
                assertEquals(false, instance.edgeExists(places[0], places[1]));
            } 
            catch (CustomException ex) 
            {
                System.err.println("testRemoveUniDirectionalEdge:" + ex.getMessage());
            }
        });
    }

    /**
     * Test of removeBiDirectionalEdge method, of class Graph.
     */
    @Test
    public void testRemoveBiDirectionalEdge() 
    {
        System.out.println("removeBiDirectionalEdge");
        Graph instance = new Graph();
        ArrayList<String> list = new ArrayList(Arrays.asList("A-B",
                                                             "A-C",
                                                             "A-D",
                                                             "D-A",
                                                             "B-F",
                                                             "C-E",
                                                             "E-F",
                                                             "D-F"));
        list.forEach((w) -> {
            String[] places = w.split("-");
            try 
            {
                instance.addBidirectionalEdge(places[0], places[1]);
                instance.removeBiDirectionalEdge(places[0], places[1]);
                assertEquals(false, instance.edgeExists(places[0], places[1]));
                assertEquals(false, instance.edgeExists(places[1], places[0]));
            } 
            catch (CustomException ex) 
            {
                System.err.println("testRemoveBiDirectionalEdge: " + ex.getMessage());
            }
        });
    }

    /**
     * Test of nodeExists method, of class Graph.
     */
    @Test
    public void testNodeExists() 
    {
        System.out.println("nodeExists");
        Graph instance = new Graph();
        ArrayList<String> list = new ArrayList(Arrays.asList("A-B",
                                                             "A-C",
                                                             "A-D",
                                                             "D-A",
                                                             "B-F",
                                                             "C-E",
                                                             "E-F",
                                                             "D-F"));
        list.forEach((w) -> {
            String[] places = w.split("-");
            try 
            {
                instance.addUnidirectionalEdge(places[0], places[1]);
                assertEquals(true, instance.nodeExists(places[0]));
                assertEquals(true, instance.nodeExists(places[1]));
            } 
            catch (CustomException ex) 
            {
                System.err.println("testNodeExists:" + ex.getMessage());
            }
        });
    }

    /**
     * Test of edgeExists method, of class Graph.
     */
    @Test
    public void testEdgeExists() 
    {
        System.out.println("edgeExists");
        Graph instance = new Graph();
        ArrayList<String> list = new ArrayList(Arrays.asList("A-B",
                                                             "A-C",
                                                             "A-D",
                                                             "D-A",
                                                             "B-F",
                                                             "C-E",
                                                             "E-F",
                                                             "D-F"));
        list.forEach((w) -> {
            String[] places = w.split("-");
            try 
            {
                instance.addUnidirectionalEdge(places[0], places[1]);
                assertEquals(true, instance.edgeExists(places[0], places[1]));
            } 
            catch (CustomException ex) 
            {
                System.err.println("testEdgeExists:" + ex.getMessage());
            }
        });
    }

    /**
     * Test of printEdges method, of class Graph.
     */
    @Test
    public void testPrintEdges() 
    {
        System.out.println("printEdges");
        Graph instance = new Graph();
        ArrayList<String> list = new ArrayList(Arrays.asList("A-B-2",
                                                             "A-C-3",
                                                             "A-D-4",
                                                             "D-A-5",
                                                             "B-F-6",
                                                             "C-E-7",
                                                             "E-F-8",
                                                             "D-F-9"));
        list.forEach((w) -> {
            String[] places = w.split("-");
            try 
            {
                instance.addUnidirectionalEdge(places[0], 
                                               places[1], 
                                               Integer.parseInt(places[2]));
            } 
            catch (CustomException ex) 
            {
                System.err.println("Exception: " + ex.getMessage());
            }
        });
        instance.printEdges();
    }

    /**
     * Test of printNodes method, of class Graph.
     */
    @Test
    public void testPrintNodes() 
    {
        System.out.println("printNodes");
        Graph instance = new Graph();
        ArrayList<String> list = new ArrayList(Arrays.asList("A-B-2",
                                                             "A-C-3",
                                                             "A-D-4",
                                                             "D-A-5",
                                                             "B-F-6",
                                                             "C-E-7",
                                                             "E-F-8",
                                                             "D-F-9"));
        list.forEach((w) -> {
            String[] places = w.split("-");
            try 
            {
                instance.addUnidirectionalEdge(places[0], 
                                               places[1], 
                                               Integer.parseInt(places[2]));
            } 
            catch (CustomException ex) 
            {
                System.err.println("Exception: " + ex.getMessage());
            }
        });
        instance.printNodes();
    }
}
