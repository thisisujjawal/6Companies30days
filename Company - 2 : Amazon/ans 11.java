class Tree 
{
    //Function to serialize a tree and return a list containing nodes of tree.
	public void serialize(Node root, ArrayList<Integer> A) 
	{
	    Queue<Node> queue = new LinkedList<>();
	    queue.offer(root);
	    while(!queue.isEmpty()){
	        Node node = queue.poll();
	        if(node == null)A.add(-1);
	        else {
	            A.add(node.data);
	            queue.offer(node.left);
	            queue.offer(node.right);
	        }
	    }
	}
	
	//Function to deserialize a list and construct the tree.
    public Node deSerialize(ArrayList<Integer> A)
    {
        Node root = new Node(A.get(0));
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        for(int i = 1 ; i < A.size() ; i+= 2){
            Node node = queue.poll();
            if(A.get(i) != -1){
                node.left = new Node(A.get(i));
                queue.offer(node.left);
            }
            if(A.get(i+1) != -1){
                node.right = new Node(A.get(i+1));
                queue.offer(node.right);
            }
        }
        return root;
    }
};
