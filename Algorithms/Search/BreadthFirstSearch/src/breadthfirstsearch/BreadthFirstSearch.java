package breadthfirstsearch;

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
public class BreadthFirstSearch 
{
    /**
     * Search for a value in the graph
     * 
     * @param graph Graph to search the value in
     * @param value value to search 
     * @return True if found, false otherwise  
     */
    public static boolean 
    search(Graph graph, String value)
    {
        HashSet<String> visited = new HashSet<>();

        Queue<String> nodes = new Queue<>();
        String current = graph.getNodes().get(0).getValue();
        // Push current node to the stack
        nodes.enqueue(current);
        // Add current node to visited set
        visited.add(current);
        
        while(!nodes.isEmpty())
        {
            current = nodes.dequeue();
            
            if(current.equals(value))
                return true;
            
            try
            {
                // Get adjecency
                ArrayList<Edge> adjecency = graph.getEdges(current);
                // Traverse through all adjecency edges
                // Put all adjecent nodes in stack, if not visited
                for(Edge e: adjecency)
                {
                    String adjecent = e.getDestination().toString();
                    if(adjecent.equals(value))
                        return true;
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
        
        // End of while - Node was not found
        return false;
    }
}
