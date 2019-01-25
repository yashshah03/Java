package graph;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Yash Shah
 */
public class Graph 
{
    private final Map<String, Edge> edgeList;
    private final Map<String, Node> nodeList;
    
    public Graph() 
    {
        edgeList = new HashMap();
        nodeList = new HashMap();
    }
    
    /**
     * Add a uni-directional edge between source and destination
     * 
     * @param source name of the source
     * @param destination name of the destination
     */
    public void addUnidirectionalEdge(String source, 
                                      String destination)
    {
        Node srcNode, destNode;
        Edge e;
        
        // check if source node exists
        if(nodeExists(source)) 
        {
            srcNode = nodeList.get(source);
        }
        else 
        {
            srcNode = new Node(source);
            nodeList.put(source, srcNode);
        }        
        // check if destination node exists
        if(nodeExists(destination)) 
        {
            destNode = nodeList.get(destination);
        }
        else 
        {
            destNode = new Node(destination);
            nodeList.put(destination, destNode);
        }
        
        // check if edge exists
        if(!edgeExists(source, destination))
        {
            e = new Edge(srcNode, destNode);
            edgeList.put(source+"|"+destination, e);
        }
        
    }
    
    /**
     * Add a uni-directional edge between source and destination with a weight
     * 
     * @param source name of the source
     * @param destination name of the destination
     * @param weight weight of the edge
     */
    public void addUnidirectionalEdge(String source, 
                                      String destination, 
                                      int weight)
    {
        addUnidirectionalEdge(source, destination);
        Edge e = edgeList.get(source +"|"+destination);
        e.setWeight(weight);
    }
    
    /**
     * Add a bi-directional edge between source and destination
     * 
     * @param source name of the source
     * @param destination name of the destination
     */
    public void addBidirectionalEdge(String source, 
                                      String destination)
    {
        addUnidirectionalEdge(source, destination);
        addUnidirectionalEdge(destination, source);
    }
    
    /**
     * Add a bi-directional edge between source and destination with a weight
     * 
     * @param source name of the source
     * @param destination name of the destination
     * @param weight weight of the edge
     */
    public void addBidirectionalEdge(String source, 
                                      String destination, 
                                      int weight)
    {
        addUnidirectionalEdge(source, destination, weight);
        addUnidirectionalEdge(destination, source, weight);
    }
    
    /**
     * Check if a node with given name exists
     * 
     * @param name name of the node
     * @return true if exists and false otherwise
     */
    public boolean nodeExists(String name)
    {
        return nodeList.containsKey(name);
    }
    
    /**
     * Check if an edge with given source and destination exists
     * 
     * @param source name of the source node
     * @param destination name of the destination node
     * @return true if exists and false otherwise
     */
    public boolean edgeExists(String source, 
                              String destination)
    {
        return edgeList.containsKey(source + "|" + destination);
    }
}
