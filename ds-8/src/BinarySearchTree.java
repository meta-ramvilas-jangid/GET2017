class BinarySearchTree {
    Node root;
    private int size ;
    private int counter;
    
    BinarySearchTree() { 
        root = null; 
    }
    void insert(int key) {
       root = insertRec(root, key);
    }
    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);
        return root;
    }
    int[] inorder()  {
    	System.out.println("Inorder");
    	int arr[]=new int[size];
        inorderRec(root,arr);
        return arr ;
    }
    void inorderRec(Node root,int[] arr) {
        if (root != null) {
            inorderRec(root.left, arr);
           arr[counter++]=root.key;
            inorderRec(root.right, arr);
        }
    }
    
    public void createBSTFromArray(int[] arr, int size){
    	this.size=size;
    	for(int i=0;i<size;i++){
    		insert(arr[i]);
    	}
    }
    public static void main(String[] args) {
    	BinarySearchTree tree = new BinarySearchTree();
        int arr[]={50,30,20,40,70,60,80};
        tree.createBSTFromArray(arr, arr.length);
        tree.inorder();
    }
}
