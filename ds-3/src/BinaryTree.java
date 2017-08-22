
class BinaryTree
{
    Node root;
    Node a;
    Node b;
 
    BinaryTree()
    {
        root = null;
    }
    /**
     * print root then go  left and right 
     * @param node - root
     */
    public void printPreorder(Node node){
    	if(node==null){
    		return ;
    	}
    	
    	System.out.print(" "+node.key);
    	printPreorder(node.left);
    	printPreorder(node.right);
    }
    /**
     * go left then rigth then print root
     * @param node - root
     */
    public void printPostorder(Node node){
    	if(node==null){
    		return ;
    	}
    	printPreorder(node.left);
    	printPreorder(node.right);
    	System.out.print(" "+node.key);
    }
    
    /*
     * Given two trees, return true if they are
     * mirror of each other
     */
	 boolean areMirror(Node a, Node b) 
	 {
	     if (a == null && b == null)
	         return true;
	
	     if (a == null || b == null) 
	         return false;
	
	     return a.key == b.key && areMirror(a.left, b.right) && areMirror(a.right, b.left);
	 }
    
    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
 
        System.out.println("Preorder traversal of binary tree is ");
        tree.printPreorder(tree.root);
 
         System.out.println("\nPostorder traversal of binary tree is ");
        tree.printPostorder(tree.root);
 
        
        //BinaryTree tree1 = new BinaryTree();
        Node a = new Node(1);
        Node b = new Node(1);
        a.left = new Node(2);
        a.right = new Node(3);
        a.left.left = new Node(4);
        a.left.right = new Node(5);
 
        b.left = new Node(3);
        b.right = new Node(2);
        b.right.left = new Node(5);
        b.right.right = new Node(4);
 
        if (tree.areMirror(a, b) == true)
            System.out.println("\nYes");
        else
            System.out.println("\nNo");
 
    }
        
    }

