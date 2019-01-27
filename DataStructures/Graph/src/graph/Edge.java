package graph;

/**
 *
 * @author Yash Shah
 */
public class Edge
{
    private Node source;
    private Node destination;
    private int weight;

    public Edge(Node source, Node destination) 
    {
        this.source = source;
        this.destination = destination;
        this.weight = 0;
    }
    
    public Edge(Node source, Node destination, int weight) 
    {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public Node getSource() { return source;}
    public Node getDestination() { return destination;}
    public int getWeight() { return weight;}
    
    public void setSource(Node source) { this.source = source;}
    public void setDestination(Node destination) { this.destination = destination;}
    public void setWeight(int weight) { this.weight = weight;}    
}
