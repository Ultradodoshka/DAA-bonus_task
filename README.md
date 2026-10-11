# DAA-bonus_task

## 1 How the operations work

### Binary Search Tree (BST)
* **Insertion:** Compares the new value with the current node. If it is smaller, it moves to the left subtree; if it is larger, it moves to the right. When it finds an empty spot, it places the new node there.
* **Search:** Checks the current node. If the value matches, the search ends. If the target is smaller, it moves left; if larger, it moves right. If it hits an empty spot, the element does not exist in the tree.
* **Deletion:** First finds the node. If the node has no children, it simply removes it. If it has one child, it replaces the node with that child. If it has two children, it finds the smallest value in the right branch, replaces the node's value with it, and deletes the duplicate below.

### Hash Table
* **Insertion:** Passes the key through a hash function to calculate its bucket index in the array. It checks the bucket's linked list for duplicates and adds the new node to the front. If the table gets too full, it doubles the array size and rehashes all elements.
* **Search:** Hashes the key to jump directly to the correct bucket, then scans that bucket's short linked list to find the matching key.
* **Deletion:** Calculates the bucket index using the hash function, locates the node in the chain, and unlinks it by pointing the previous node directly to the next node.


## 2 Best-Case and Worst-Case Time Complexity

### Binary Search Tree
* **Search:**
    * Best case is O(1) when the target element is located right at the root.
    * Worst case is O(n) when elements were inserted in sorted order, turning the tree into a single straight line where every node must be checked.
* **Insertion:**
    * Best case is O(1) when inserting into an empty tree, making the node the root immediately.
    * Worst case is O(n) when the tree is unbalanced into a single line, requiring a full traversal to the bottom to insert.
* **Deletion:**
    * Best case is O(1) when deleting the root node with zero or one child.
    * Worst case is O(n) when the tree is unbalanced into a line, forcing a traversal through all nodes to locate and remove the target.

### Hash Table
* **Search:**
    * Best case is O(1) when the element is the first item in the bucket with no collisions.
    * Worst case is O(n) when all keys produce the exact same hash, placing every element into a single bucket that must be searched from start to finish.
* **Insertion:**
    * Best case is O(1) when the key is placed directly into an empty bucket.
    * Worst case is O(n) when the table exceeds its capacity and triggers a resize (allocating a new array and rehashing all elements), or when all elements collide into one bucket.
* **Deletion:**
    * Best case is O(1) when the target node is right at the head of the bucket's list.
    * Worst case is O(n) when heavy collisions force all items into one bucket, requiring a linear scan to find the node.


## 5 Result

![result](img/img.png)

## 4 Why Performance Differs in Practice

* **CPU Cache Locality:** A hash table is built on a continuous array in memory, allowing the CPU to load chunks of it into high-speed cache. BST nodes are scattered individually across memory, so following pointers from node to node frequently triggers slow memory reads (cache misses).
* **Branch Prediction:** Traversing a tree requires checking conditional statements at every level, which can cause CPU branch mispredictions. A hash table calculates an index using basic math, avoiding repeated branch checks.
* **Input Sensitivity:** A standard BST degrades to O(n) if the input data is already sorted (such as auto-incrementing IDs). A hash table is not affected by input order because the hash function scatters values across buckets regardless.
* **Intended Use Case:** Hash tables are faster for direct key lookups. BSTs trade some lookup speed for structural order: they keep data sorted and can handle range queries (such as finding all values between 10 and 50), which a hash table cannot do without sorting everything from scratch.