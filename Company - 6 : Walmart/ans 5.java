class Solution{
    public void toSumTree(Node root){
        solve(root);
    }
    public static int solve(Node node){
        if(node == null){
            return 0;
        }
        int left = solve(node.left);
        int right = solve(node.right);
        int sum = left+right+node.data;
        node.data = left+right;
        return sum;
    }
}
