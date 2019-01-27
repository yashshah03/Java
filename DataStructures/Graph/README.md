## This project contains sample implementation of a Graph in java
**The project is developed using Apache Netbeans IDE 10.0, Java 8, Windows 10**

## Features:
   - [X] Thread safe

## Methods:
   - addUnidirectionalEdge(source, destination)
     * Add a uni-directional edge between source and destination
   - addUnidirectionalEdge(source, destination, weight)
     * Add a uni-directional edge between source and destination with weight  
   - addBidirectionalEdge(source, destination) 
     * Add a bi-directional edge between source and destination
   - addBidirectionalEdge(source, destination, weight)
     * Add a bi-directional edge between source and destination with weight
   - changeUniDirectionalEdgeWeight(source, destination, weight)
     * Change the weight of an existing edge
   - changeBiDirectionalEdgeWeight(source, destination, weight)
     * Change the weight of an existing bi-directional edge
   - removeUniDirectionalEdge(source, destination)
     * Removes a uni-directional edge
   - removeBiDirectionalEdge(source, destination)
     * Removes a bi-directional edge
   - nodeExists(name)
     * Check if a node with given name exists
   - edgeExists(source,destination)
     * Check if an edge with given source and destination exists
   - edgeExists(source,destination,weight)
     * Check if an edge with given source, destination and weight exists
   - printEdges()
     * Print all edges in the graph
   - printNodes()
     * Print all nodes in the graph