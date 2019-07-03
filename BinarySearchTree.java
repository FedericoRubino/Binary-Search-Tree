/*
  Federico Rubino
  frubino
  Assignment #7
  Binary Search Tree
  BinarySeaarchTree.java
  tested/ working
*/

public class BinarySearchTree{

    private class Node{

	private Node(){ left = right = parent = null; }

	//Node member variables
	private int key; //data
	private Node left; //less 
	private Node right; // greater 
	private Node parent;
    }

    //constructor
    public BinarySearchTree(){
	root = null;
    }

    //search for the Node that contains certain key
    private Node search(Node x, int key){
	if(x == null || x.key == key) return x;
	if(key < x.key)
	    return search(x.left, key);
	else
	    return search(x.right, key);
    }

    //wrapper for search
    public boolean search(int key){
	if(search(root, key) != null){
	    System.out.printf("%d found.%n", key);
	    return true;
	} else {
	    System.out.printf("%d not found.%n", key);
	    return false;
	}
    }

    //inserts new node into the tree
    private void insert(Node n){
	Node parent = null;
	Node temp = root;
	while(temp != null){
	    parent = temp;
	    if(n.key < temp.key)
		temp = temp.left;
	    else
		temp = temp.right;
	}//while
	n.parent = parent;
	if(parent == null){
	    root = n;
	    return;
	}
	if(n.key < parent.key)
	    parent.left = n;
	else
	    parent.right = n;
    }

    //wrapper for insert
    public void insert(int key){
	Node insrt = new Node();
	insrt.key = key;
	insert(insrt);
	System.out.printf("inserted %d.%n", key);
    }

    //delete function
    private void delete(Node n){
	Node target = null;
	Node x = null;
	if(n.left == null || n.right == null)
	    target = n;
	else
	    target = successor(n);
	if(target.left != null)
	    x = target.left;
	else
	    x = target.right;
	if(x != null)
	    x.parent = target.parent;
	if(target.parent == null)
	    root = x;
	else if (target == target.parent.left)
	    target.parent.left = x;
	else
	    target.parent.right = x;
	if(target != n)
	    n.key = target.key;	    
	return;
    }
    
    //wrapper for delete
    public void delete(int key){
	Node toDel = search(root, key);
	if(toDel != null){
	    delete(toDel);
	    System.out.printf("deleted %d.%n", key);
	} else 
	    System.out.printf("delete %d - not found.%n", key);
    }
    
    //print in numeric order L P R
    private void inorder(Node x){
	if(x == null) return;
	inorder(x.left);
	print(x);
	inorder(x.right);
    } 
    
    //wrapper for inorder
    public void inorder(){
	if(root == null){ return;}
	System.out.println("inorder traversal:");
	inorder(root);
	System.out.println(); //new line
    }

    //prints the tree in preorder P L R
    private void preorder(Node x){
	if(x == null) return;
	print(x);
	preorder(x.left);
	preorder(x.right);
    } 

    //wrapper for preorder
    public void preorder(){
	if(root == null){ return;}
	System.out.println("preorder traversal:");
	preorder(root);
	System.out.println();
    }

    //prints a list in the post order L R P
    private void postorder(Node x){
	if(x == null) return;
	postorder(x.left);
	postorder(x.right);
	print(x);
    } 

    //wrapper for postorder
    public void postorder(){
	if(root == null){ return;}
	System.out.println("postorder traversal:");
	postorder(root);
	System.out.println();
    }
    
    //returns the smallest
    private Node min(Node x){
	while(x.left != null)
	    x = x.left;
	return x;
    }
    
    //wrapper for min
    public void min(){
	if(root != null)
	    System.out.printf("min is %d.%n", min(root).key);
    }
    
    //returns largest
    private Node max(Node x){
	while(x.right != null)
	    x = x.right;
	return x;
    }
    
    //wrapper for max
    public void max(){
	if(root != null)
	    System.out.printf("max is %d.%n", max(root).key);
    }
    
    //returns the integer that succeeds the given Node (greater than)
    private Node successor(Node x){
	if(x.right != null){
	    return min(x.right);
	}
	Node temp = x.parent;
	while(temp != null && x == temp.right){
	    x = temp;
	    temp = temp.parent;
	}
        return temp;
    }
    
    //wrapper for successor
    public void successor(int a){
	Node temp = search(root, a);
	if(temp != null){
	    Node succ = successor(temp);
	    if(succ != null)
		System.out.printf("%d successor is %d.%n",a,succ.key);
	    else
		System.out.printf("no successor for %d.%n",a);
	}else
	    System.out.printf("%d not in tree.%n", a);
    }
    

    //finds the predecessor (less than)
    private Node predecessor(Node x){
	if(x.left != null){
	    return max(x.left);
	}
	Node temp = x.parent;
	while(temp != null && x == temp.left){
	    x = temp;
	    temp = temp.parent;
	}
        return temp;
    }
    
    //wrapper for predecessor
    public void predecessor(int a){
	Node temp = search(root, a);
	if(temp != null){
	    Node pred = predecessor(temp);
	    if(pred != null)
		System.out.printf("%d predecessor is %d.%n",a,pred.key);
	    else
		System.out.printf("no predecessor for %d.%n",a);
	}else
	    System.out.printf("%d not in tree.%n", a);
    }
    
    //helper function for the three order functions
    private void print(Node x){
	if(x != null)
	    System.out.printf("%d ", x.key);
    }
    
    //member variables
    private Node root;

}
