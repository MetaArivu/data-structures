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

import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Node Tree Builder
 * 
 * Converts Row / Column Data into a Tree Data Model
 * 
 * @author Araf Karsh Hamid
 * @version 1.0
 * @date 201903114010000
 */
public class NodeTreeBuilder {
	
	/**
	 * Builds the Tree from a Sorted Array of Nodes
	 * 
	 * @param _nodeArray
	 * @return
	 */
	public final static Node build(Node[] _nodeArray) {
		Node root 	= new Node("Root");
		return buildTree(root, _nodeArray);
	}
	
	/**
	 * Builds the Actual Tree
	 * 
	 * @param root
	 * @param _nodeArray
	 * @return
	 */
	private static Node buildTree(Node root, Node[] _nodeArray) {
		HashMap<String,Node> nodeMap = new HashMap<String,Node>();
		for(int row=0; row<_nodeArray.length; row++) {
			Node child = _nodeArray[row];
			nodeMap.put(child.getNodeId(), child);
			if(child.getNodeLevel() == 1) {
				root.addNode(child);
			} else {
				Node parent = getParent(nodeMap, child);
				if(parent != null) {
					parent.addNode(child);
				}
			}
			
		}
		return root;
	}
	
	/**
	 * Finds the Parent of a Child.
	 * 
	 * @param _nodeMap
	 * @param _child
	 * @return
	 */
	private static Node getParent(HashMap<String,Node> _nodeMap, Node _child) {
		Node node = null;
		for(String key : _nodeMap.keySet()) {
			if(_child.getNodeId().startsWith(key)) {
				node = _nodeMap.get(key);
				int parentLevel = _child.getNodeLevel()-node.getNodeLevel();
				if(parentLevel == 1) {
					return node;
				}
			}
		}
		return node;
	}
}
