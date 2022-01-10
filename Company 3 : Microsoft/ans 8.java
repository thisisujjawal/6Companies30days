class Solution
{
    //Function to connect nodes at same level.
    public void connect(Node root)
    {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        while(!queue.isEmpty() && queue.peek() != null){
            Node node = queue.poll();
            if(node.left != null)queue.offer(node.left);
            if(node.right != null)queue.offer(node.right);
            while(queue.peek() != null){
                node.nextRight = queue.peek();
                node = queue.poll();
                if(node.left != null)queue.offer(node.left);
                if(node.right != null)queue.offer(node.right);
            }
            queue.offer(null);
            queue.poll();
        }
    }
}
