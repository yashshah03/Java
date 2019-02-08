/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package depthfirsttraverse;

import customexception.CustomException;
import graph.Graph;
import org.junit.Test;

/**
 *
 * @author Yash Shah
 */
public class DepthFirstTraverseTest 
{
    /**
     * Test of traverse method, of class DepthFirstTraverse.
     */
    @Test
    public void testTraverse() 
    {
        System.out.println("traverse");
        DepthFirstTraverse.traverse(createNewGraph());
    }
        
    private Graph 
    createNewGraph()
    {
        Graph graph = new Graph();
        try
        {
            graph.addUnidirectionalEdge("Astana", "Delhi", 4126);
            graph.addUnidirectionalEdge("Astana", "Beijing", 4175);
            graph.addUnidirectionalEdge("Astana", "Moscow", 2150);
            graph.addUnidirectionalEdge("Delhi", "Singapor", 4140);
            graph.addUnidirectionalEdge("Beijing", "Singapor", 4742);
            graph.addUnidirectionalEdge("Beijing", "Tokyo", 2098);
            graph.addUnidirectionalEdge("Moscow", "London", 2498);
            graph.addUnidirectionalEdge("Moscow", "Algiers", 3336);
            graph.addUnidirectionalEdge("Moscow", "Barcelona", 3006);
            graph.addUnidirectionalEdge("Singapor", "Brisbane", 6152);
            graph.addUnidirectionalEdge("Tokyo", "Honolulu", 6195);
            graph.addUnidirectionalEdge("Tokyo", "Anchorage", 5555);
            graph.addUnidirectionalEdge("London", "Boston", 5264);
            graph.addUnidirectionalEdge("Algiers", "San Juan", 7015);
            graph.addUnidirectionalEdge("Barcelona", "Boston", 5861);
            graph.addUnidirectionalEdge("Brisbane", "Honolulu", 7566);
            graph.addUnidirectionalEdge("Honolulu", "San Fransicso", 3851);
            graph.addUnidirectionalEdge("Anchorage", "Vancouver", 2129);
            graph.addUnidirectionalEdge("Boston", "Vancouver", 4022);
            graph.addUnidirectionalEdge("San Juan", "Houston", 3178);
            graph.addUnidirectionalEdge("San Juan", "Helena", 5194);
            graph.addUnidirectionalEdge("San Fransicso", "Vancouver", 1276);
            graph.addUnidirectionalEdge("Houston", "Vancouver", 3184);
            graph.addUnidirectionalEdge("Helena", "Vancouver", 880);
        }
        catch (CustomException ex)
        {
            System.err.println(ex.getMessage());
        }
        return graph;
    }
}
