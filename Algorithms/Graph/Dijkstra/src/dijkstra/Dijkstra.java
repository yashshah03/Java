package dijkstra;

import customexception.CustomException;
import graph.Edge;
import graph.Graph;
import graph.Node;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Yash Shah
 */
public class Dijkstra 
{
    private Graph graph = new Graph();
    private HashMap<String, Integer> distances = new HashMap();
    private HashMap<String, Boolean> visited = new HashMap();
    private HashMap<String, String> previous = new HashMap();
    private String source = "";
    private int unvisited = 0;
    
    /**
     * Set the graph to be used
     * 
     * @param graph 
     */
    public void 
    setGraph(Graph graph)
    {
        this.graph = graph;
    }
    
    
    /**
     * Set source node for the graph
     * 
     * @param source name of the source node
     */
    public void 
    setSource(String source)
    {
        this.source = source;
    }
    
    /**
     * Calculate minimum distance of all nodes from source
     */
    public void
    calculateShortestDistnaces()
    {
        if(this.source.equals(""))
        {
            System.err.println("No source was defined. Use setSource()");
            return;
        }
        this.distances = new HashMap();
        // Initialize all distances to max
        ArrayList<Node> nodes = this.graph.getNodes();
        nodes.forEach((node) -> {
            this.distances.put(node.toString(), Integer.MAX_VALUE);
            this.visited.put(node.toString(), false);
            this.previous.put(node.toString(), "None");
            this.unvisited++;
        });
        // Set the source distance to 0
        this.distances.put(this.source, 0);
        
        // Calculate distances
        try 
        {                 
            while(this.unvisited > 0)
            {
                //Get closest un-visited vertex
                String current = getClosestUnvisitedNode();
                visited.put(current, true);
                this.unvisited--;
                // Get adjecency
                ArrayList<Edge> adjecency = this.graph.getEdges(current);
                // Traverse through all adjecency edges
                adjecency.forEach((e) -> {
                    String adjecent = e.getDestination().toString();
                    if (!isVisited(adjecent)) {
                        int newDistToAdjecent = distance(current)+e.getWeight();
                        if (distance(adjecent) > newDistToAdjecent) {
                            this.distances.put(adjecent, newDistToAdjecent);
                            this.previous.put(adjecent, current);
                        }
                    }
                });
            } 
        }
        catch (CustomException ex) { System.err.println(ex); } 
    }
    
    /**
     * Print paths to all nodes from source
     */
    public void
    printOutput()
    {
        if(this.source.equals(""))
        {
            System.err.println("No source was defined. Use setSource()");
            return;
        }
        ArrayList<Node> nodes = this.graph.getNodes(); 
        nodes.stream().map((n) -> n.toString()).forEachOrdered((current) -> {
            if(this.source.equals(current))
                System.out.print("\nDestination: " + current +
                        "(distance: " + distance(current) + ")\n" +
                        "Path:\t-> " + this.source + " -> " + this.source);
            else if(this.previous.get(current).equals("None"))            
                System.err.println("No path from " + 
                                   this.source + " to " + current);
            else
            {
                ArrayList<String> path = new ArrayList();
                if(printPathRecursive(current, this.source, path))
                {
                    System.out.print("\nDestination: " + current +
                            "(distance: "+distance(current) + ")\n" +
                                    "Path:\t");
                    path.forEach((node)->{
                        System.out.print(" -> " + node);
                    });
                }
                else
                    System.err.println("No path from " +
                                       this.source + " to " + current);
                
            }
        });
        System.out.print("\n");
    }
    
    
    /**************************
     * PRIVATE HELPER METHODS *
     **************************/
    
    private boolean 
    printPathRecursive(String current, String source, ArrayList<String> path)
    {
        boolean returnVal = true;
        if(current.equals(source))
            path.add(source);
        else if(this.previous.get(current).equals("None"))
            returnVal =  false;
        else
        {
            returnVal = printPathRecursive(this.previous.get(current), source, path);
            path.add(current);
        }
        
        return returnVal;
    }
    
    private String
    getClosestUnvisitedNode()
    {
        ArrayList<Node> nodes = this.graph.getNodes(); 
        int min = Integer.MAX_VALUE;
        String closest = "";
        
        for(Node n: nodes)
        {
            if(!(isVisited(n.toString())) && distance(n.toString()) <= min)
            {
                min = distance(n.toString());
                closest = n.toString();
            }
        }        
        return closest;
    }
    
    private boolean 
    isVisited(String node)
    {
        return this.visited.get(node);
    }
    
    private int 
    distance(String node)
    {
            return this.distances.get(node);
    }
}
