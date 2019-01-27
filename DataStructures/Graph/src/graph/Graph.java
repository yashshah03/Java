package graph;

import java.util.HashMap;
import java.util.Map;

import customexception.CustomException;

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
     * @throws CustomException
     */
    public synchronized void
    addUnidirectionalEdge(String source, 
                          String destination) 
    throws CustomException
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
            edgeList.put(getEdgeName(source, destination), e);
        }
        else
        {
            throw new CustomException("Edge already exists",
                                      GraphEx.EDGE_ALREADY_EXISTS.c());
        }
    }
    
    /**
     * Add a uni-directional edge between source and destination with a weight
     * 
     * @param source name of the source
     * @param destination name of the destination
     * @param weight weight of the edge
     * @throws CustomException
     */
    public synchronized void 
    addUnidirectionalEdge(String source, 
                          String destination, 
                          int weight) 
    throws CustomException
    {
        addUnidirectionalEdge(source, destination);
        Edge e = edgeList.get(getEdgeName(source, destination));
        e.setWeight(weight);
    }
    
    /**
     * Add a bi-directional edge between source and destination
     * 
     * @param source name of the source
     * @param destination name of the destination
     * @throws CustomException
     */
    public void 
    addBidirectionalEdge(String source, 
                         String destination) 
    throws CustomException
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
     * @throws CustomException
     */
    public void 
    addBidirectionalEdge(String source, 
                         String destination, 
                         int weight) 
    throws CustomException
    {
        addUnidirectionalEdge(source, destination, weight);
        addUnidirectionalEdge(destination, source, weight);
    }
    
    /**
     * Change the weight of an existing edge
     * 
     * @param source name of the source node
     * @param destination name of the destination node
     * @param weight new weight to assign
     * @throws CustomException if the edge does not exist
     */
    public synchronized void 
    changeUniDirectionalEdgeWeight(String source,
                                   String destination,
                                   int weight)
    throws CustomException
    {
        if(edgeExists(source, destination))
        {
            Edge e = edgeList.get(getEdgeName(source, destination));
            e.setWeight(weight);
        }
        else
        {
            throw new CustomException("Edge does not exist", 
                                       GraphEx.EDGE_DOES_NOT_EXIST.c());
        }
    }
    
    /**
     * Change the weight of an existing bi-directional edge
     * 
     * @param source name of the source node
     * @param destination name of the destination node
     * @param weight new weight to assign
     * @throws CustomException if the edge does not exist
     */
    public synchronized void 
    changeBiDirectionalEdgeWeight(String source,
                                  String destination,
                                  int weight)
    throws CustomException
    {
        changeUniDirectionalEdgeWeight(source, destination, weight);
        changeUniDirectionalEdgeWeight(destination, source, weight);
    }
    
    /**
     * Removes a uni-directional edge
     * 
     * @param source name of the source node 
     * @param destination name of the destination node
     * @throws CustomException
     */
    public synchronized void 
    removeUniDirectionalEdge(String source,
                             String destination) 
    throws CustomException
    {
        // check if source node exists
        if(!nodeExists(source)) 
        {
            throw new CustomException("Source node was not found " + source, 
                                      GraphEx.SOURCE_NODE_DOES_NOT_EXIST.c());
        }        
        // check if destination node exists
        if(!nodeExists(destination)) 
        {
            throw new CustomException("Destination node was not found " + destination , 
                                      GraphEx.DESTINATION_DOES_NOT_EXIST.c());
        }
        
        // check if edge exists
        if(!edgeExists(source, destination))
        {
            throw new CustomException("Edge was not found" + 
                                      source + " - " + destination, 
                                      GraphEx.EDGE_DOES_NOT_EXIST.c());
        } 
        else
        {
            edgeList.remove(getEdgeName(source, destination));
        }
    }
    
    /**
     * Removes a bi-directional edge
     * 
     * @param source name of the source node 
     * @param destination name of the destination node
     * @throws CustomException
     */
    public void 
    removeBiDirectionalEdge(String source,
                            String destination) 
    throws CustomException
    {
        removeUniDirectionalEdge(source, destination);
        removeUniDirectionalEdge(destination, source);
    }
    
    /**
     * Check if a node with given name exists
     * 
     * @param name name of the node
     * @return true if exists and false otherwise
     */
    public boolean 
    nodeExists(String name)
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
    public boolean 
    edgeExists(String source, 
               String destination)
    {
        return edgeList.containsKey(getEdgeName(source, destination));
    }
    
    /**
     * Check if an edge with given source and destination exists
     * 
     * @param source name of the source node
     * @param destination name of the destination node
     * @param weight weight of the edge
     * @return true if exists and false otherwise
     */
    public boolean 
    edgeExists(String source, 
               String destination,
               int weight)
    {
        if(edgeList.containsKey(getEdgeName(source, destination)))
            return edgeList.get(getEdgeName(source, destination)).getWeight() == weight;
        else
            return false;
    }
    
    /**
     * Print all edges in the graph
     */
    public void 
    printEdges()
    {
        String format = "%-20s%-20s%-10s\n";
        System.out.format(format, "Source", "Destination", "Weight");
        // Print all edges - Source, Destination and weight
        format = "%-20s%-20s%4d\n";
        for (Edge e : edgeList.values()) 
        {
            System.out.format(format, e.getSource(), e.getDestination(), e.getWeight());
        }
    }    
    
    /**
     * Print all nodes in the graph
     */
    public void 
    printNodes()
    {
        nodeList.keySet().forEach((node) -> {
            System.out.println(node);
        });
    }
    
    private String 
    getEdgeName(String source, String destination)
    {
        return source+"|"+destination;
    }
}

