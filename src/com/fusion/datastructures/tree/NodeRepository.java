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

import java.util.Arrays;
import java.util.Collections;

/**
 * Returns the All the Node levels from the database
 * sorted on Level - As per the Tree Order.
 * 
 * @author Araf Karsh Hamid
 * @version 1.0
 * @date 201903114010000
 */
public class NodeRepository {
	
	// Mocking the Database records in an unsorted fashion.
	// Query to the Database Should have order by clause on Level field.
	private Node[] nodeData = {
			new Node("1"),
			new Node("1.4"),
			new Node("1.1"),
			new Node("1.1.1"),
			new Node("1.1.2"),
			// new Node("1.1.3"),
			new Node("2"),
			new Node("2.2"),
			new Node("3"),
			new Node("2.1"),
			new Node("2.1.1"),
			new Node("2.1.2"),
			new Node("2.2.1"),
			new Node("3.1"),
			new Node("2.2.2"),
			new Node("3.2"),
			new Node("1.5"),
			new Node("1.2"),
			new Node("1.2.1"),
			new Node("1.2.2"),
			// new Node("1.2.3"),
			new Node("1.3"),
			new Node("1.2.4"),
			// new Node("1.2.5"),
			new Node("1.5.1"),
			new Node("1.7"),
			new Node("1.5.2"),
			new Node("3.2.1"),
			new Node("3.2.2"),
			new Node("3.2.3"),
			new Node("1.6"),
			new Node("1.6.1")

	};
	
	/**
	 * Returns all the Node Data Sorted
	 * @return
	 */
	public Node[] getAllNodesSorted() {
		printData("Un-Sorted");
		// Soring the data. This is not required if the 
		// If the data is already sorted from the database.
		Arrays.sort(nodeData);
		// printData("Sorted");
		return nodeData;
	}
	
	/**
	 * Print the Data
	 * @param _mode
	 */
	public void printData(String _mode) { 
		System.out.println("Printing Node Data : "+_mode+" >>>>>>>> .........");
		int total = nodeData.length;
		for(int x=0; x<total; x++) {
			System.out.println(nodeData[x]);
		}
	}

}
