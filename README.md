# data-structures
Data Structures - Converting Table Data (Rows and Columns) into tree structure.

Following Example shows how to create a Parent Child relationship with a single field in a relational database.

Data Structure in Rows and Columns
NodeID | Name | Description
1 | Security | 
1.1 | Security Assessment | 
1.1.1 | Vulnerability Assessment
1.1.2 | Asset Discovery
1.1.3 | Service Discovery

Sample Data (Node ID) in Rows

1
1.4
1.1
1.1.1
1.1.2
2
2.2
3
2.1
2.1.1
2.1.2
2.2.1
3.1
2.2.2
3.2
1.5
1.2
1.2.1
1.2.2
1.3
1.2.4
1.5.1
1.7
1.5.2
3.2.1
3.2.2
3.2.3
1.6
1.6.1

This unsorted data will be sorted and creates a tree structure. Ideally when you fetch the data from the Database you can get the data sorted based on Node ID.

Tree Data - After Sorting the Data -=-=-=-=-=-=-=-=-=-=-=-=-
Root
  1
    1.1
      1.1.1
      1.1.2
    1.2
      1.2.1
      1.2.2
      1.2.4
    1.3
    1.4
    1.5
      1.5.1
      1.5.2
    1.6
      1.6.1
    1.7
  2
    2.1
      2.1.1
      2.1.2
    2.2
      2.2.1
      2.2.2
  3
    3.1
    3.2
      3.2.1
      3.2.2
      3.2.3
