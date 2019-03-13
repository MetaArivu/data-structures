/**
 * Copyright (c) 2019 Araf Karsh Hamid

 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:

 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.

 * This program and the accompanying materials are dual-licensed under
 * either the terms of the Eclipse Public License v1.0 as published by
 * the Eclipse Foundation
 
 *   or (per the licensee's choosing)
 
 * under the terms of the Apache 2 License version 2.0
 * as published by the Apache Software Foundation.
*/
package com.fusion.datastructures.tree;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Node Data Model
 * 
 * @author Araf Karsh Hamid
 * @version 1.0
 * @date 201903114010000
 */
public class Node implements Comparable<Node> {
	
	private final String nodeId;
	private Node parent;
	private final ArrayList<Node> nodes;
	private final int nodeLevel;
	
	private boolean isLeaf = false;
	private String nodeName;
	private String nodeSortOrder;
	private String nodeDescription;
	
	/**
	 * 
	 * @param _nodeId
	 */
	public Node(String _nodeId) {
		this(_nodeId, null);
	}
	
	/**
	 * Create a Node with a unique level
	 * @param _nodeId
	 */
	public Node(String _nodeId, Node _parent) {
		nodeId 		= (_nodeId != null) ? _nodeId : "1";
		nodeLevel 	=  new StringTokenizer(_nodeId, ".").countTokens();
		nodes 		= new ArrayList<Node>();
		parent 		= _parent;
	}
	
	/**
	 * Set the Parent
	 * @param _parent
	 * @return
	 */
	public Node setParent(Node _parent) {
		if(_parent != null) {
			parent = _parent;
		}
		return this;
	}
	
	/**
	 * Returns TRUE if the parent is available
	 * 
	 * @return
	 */
	public boolean isParentAvailable() {
		return (parent == null) ? false : true;
	}

	/**
	 * Sets TRUE if the Node is a Leaf
	 */
	public Node setLeaf() {
		isLeaf = (nodes.size() == 0) ? true : false;
		return this;
	}
	
	/**
	 * Returns the Parent
	 * @return
	 */
	public Node getParent() {
		return parent;
	}
	
	/**
	 * Returns TRUE if the Node is a leaf. 
	 * No Child Nodes.
	 * 
	 * @return
	 */
	private boolean isLeaf() {
		return isLeaf;
	}
	
	/**
	 * Add Child Node
	 * @param n
	 * @return
	 */
	public Node addNode(Node n) {
		nodes.add(n);
		return this;
	}
	
	/**
	 * Compares the Levels of 2 nodes
	 */
	@Override
	public int compareTo(Node _node) {
		return this.nodeId.compareTo(_node.nodeId);
	}
	
	/**
	 * Return the Node Level
	 * @return
	 */
	public int getNodeLevel() {
		return nodeLevel;
	}

	/**
	 * Returns the String
	 * @return
	 */
	public String getNodeId() {
		return nodeId;
	}
	
	/**
	 * Returns Node in String format
	 */
	public String toJSONString() {
		StringBuilder sb = new StringBuilder();
		return sb.toString();
	}
	
	/**
	 * Print All Node Values
	 */
	public void printNodes() {
		String t = getTabs(nodeLevel);
		System.out.println("Node> "+t+nodeId);
		for(Node n : nodes) {
			n.printNodes();
		}
	}
	
	private String getTabs(int _level) {
		StringBuilder sb = new StringBuilder();
		for(int x=0; x<_level; x++) {
			sb.append("  ");
		}
		return sb.toString();
	}
	
	/**
	 * Return String
	 */
	public String toString() {
		return nodeId;
	}
}
