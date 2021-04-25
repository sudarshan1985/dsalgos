package searchalgo;

public class Binarysearchtree
{
   //First define the Node for the binary search tree
	class Node {
		
		 Node left;
		 Node right;
		 int  data; 
		 
		 //Constructor to set the key for the node
		 //when new node is created the left and right is null
		 Node(int data)
		 {
			this.data = data;
			this.left = null;
			this.right = null;
		 }
		
		
	}
	
	//Define a root node
	 Node root;
	
	//Constructor for Binarysearchtree
	 Binarysearchtree()
	 {
		 this.root = null;
	 }
	 	 
	//Functions in BST 
	
	 //Insert a Node.
	 void insert(int data)
	 {
		root = recursiveinsert(root,data);
	 }
	 
	  Node recursiveinsert(Node root, int data)
	 {
		Node newnode = new Node(data);		 
	    if(root==null)
	    {
	    	root = newnode;
	    	return root;
	    }
	    else
	    {
	      if(data < root.data)
	    	root.left = recursiveinsert(root.left,data);
	      if(data > root.data)
	    	root.right = recursiveinsert(root.right,data); 
	    }
	    
	    return root;
	    
	 }
	
	 //Inorder traversal 
	 void inorder()
	 {
		inorderTraversal(root);
	 }
	
	 void inorderTraversal(Node root)
	 {
	   if(root!=null)
	   {
		inorderTraversal(root.left);
		System.out.println(root.data);
		inorderTraversal(root.right);
	   }
	 }
	
	 //Deleting the Node
	 void delete(int data)
	 {
		 root = recursiveDelete(root,data);
	 }
	 
	 Node recursiveDelete(Node root,int data)
	 {
		if(root == null)
			return root;
	 
		if(data < root.data)
			root.left = recursiveDelete(root.left,data);
		else if(data > root.data)
			root.right = recursiveDelete(root.right,data);
		
		else   //Found the root to be delete, adjust now
		{ 
		   if(root.left == null )
			   return root.right;
		   
		   if(root.right == null)
			   return root.left;
		   
		  //If it comes here then it has two children
		   root.data = findMinval(root.right);
		   
		   root.right = recursiveDelete(root.right,root.data);
		  
		}
			
		return root;
	 }
	 
	 int findMinval(Node root)
	 {
		 int minval=0;
		 while(root.left!=null)
		 {
		   minval=root.left.data;
		   root = root.left;
		 }
		 
		 return minval;
	 }
	 
	// Driver Code
	    public static void main(String[] args)
	    {
	        Binarysearchtree tree = new Binarysearchtree();
	 
	        /* Let us create following BST
	              50
	           /     \
	          30      70
	         /  \    /  \
	        20   40  60   80 */
	        tree.insert(50);
	        tree.insert(30);
	        tree.insert(20);
	        tree.insert(40);
	        tree.insert(70);
	        tree.insert(60);
	        tree.insert(80);
	 
	        System.out.println(
	            "Inorder traversal of the given tree");
	        tree.inorder();
	 
	        System.out.println("\nDelete 20");
	        tree.delete(20);
	        System.out.println(
	            "Inorder traversal of the modified tree");
	        tree.inorder();
	 
	        System.out.println("\nDelete 30");
	        tree.delete(30);
	        System.out.println(
	            "Inorder traversal of the modified tree");
	        tree.inorder();
	 
	        System.out.println("\nDelete 50");
	        tree.delete(50);
	        System.out.println(
	            "Inorder traversal of the modified tree");
	        tree.inorder();
	    }
	}