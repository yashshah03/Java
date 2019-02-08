package breadthfirsttraverse;

import customexception.CustomException;
import graph.Edge;
import graph.Graph;
import java.util.ArrayList;
import java.util.HashSet;
import queue.Queue;

/**
 *
 * @author Yash Shah
 */
public class BreadthFirstTraverse 
{       
    /**
     * Traverse the graph Breadth First
     * 
     * @param graph The graph to traverse
     */
    public static void 
    traverse(Graph graph)
    {
        HashSet<String> visited = new HashSet<>();
    
        Queue<String> nodes = new Queue<>();
        String current = graph.getNodes().get(0).getValue();
        // Push current node to the stack
        nodes.enqueue(current);
        // Add current node to visited set
        visited.add(current);
        System.out.println("CURRENT: " + current);
        
        while(!nodes.isEmpty())
        {
            current = nodes.dequeue();
            System.out.println(current);
            try
            {
                // Get adjecency
                ArrayList<Edge> adjecency = graph.getEdges(current);
                // Traverse through all adjecency edges
                // Put all adjecent nodes in stack, if not visited
                for(Edge e: adjecency)
                {
                    String adjecent = e.getDestination().toString();
                    if(!visited.contains(adjecent))
                    {
                        nodes.enqueue(adjecent);
                        visited.add(adjecent);
                    }
                }
            }
            catch(CustomException e)
            {
                System.err.println("[ERROR] " + e.getMessage());
            }
        }
    }
}
