class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    
    public static int minTime(Node root, int target) 
    {
        return solve(root , target).height;
    }
    public static Pair solve(Node node, int target){
        if(node == null)return new Pair(0,0);
        Pair a = solve(node.left, target);
        Pair b = solve(node.right, target);
        
        if(node.data == target)return new Pair(Math.max(a.height , b.height), 1);
        
        if(a.time > 0){
            int height = Math.max(b.height + a.time, a.height);
            return new Pair(height, a.time+1);
        }else if(b.time > 0){
            int height = Math.max(a.height + b.time, b.height);
            return new Pair(height, b.time+1);
        }else{
            return new Pair(Math.max(a.height , b.height)+1 , 0);
        }
    }
    public static class Pair{
        int height = 0;
        int time = 0;
        Pair(int height, int time){
            this.height = height;
            this.time = time;
        }
    }
}
