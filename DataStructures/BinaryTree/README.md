## This project contains sample implementation of a BinaryTree in java
**The project is developed using Apache Netbeans IDE 10.0, Java 8, Windows 10**

## Features:
   - [X] Generic support (Can be used with any data types).
   - [X] Uses interface - Concrete implementation (Mimicking std java Queue (iface) - Linkedlist (concrete))

## Methods:
   - public BinaryTreeNode createBT(value)
     * creates a binary tree with value set for the root node
   - insertLeftBTNode(parentNode, value) throws CustomException
     * Creates and inserts left child with value to the parent node
   - insertRightBTNode(parentNode,value) throws CustomExceptio
     * Creates and inserts right child with value to the parent node
   - deleteBTNode(value)
     * Removes node with given value. If multiple nodes exists, removes the first node found in pre-order traversal
   - containsBTNode(value)
     * Pre-order check whether or not a node with given value exists
   - getBTNodes(value)
     * Retrieve all nodes with given value