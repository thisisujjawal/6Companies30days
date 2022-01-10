class Tree
{
    //Function to count number of subtrees having sum equal to given sum.
    public static int ans = 0;
    int countSubtreesWithSumX(Node root, int X)
    {
        ans = 0;
        solve(root , X);
        return ans;
    }
    public static int solve(Node node, int target){
        if(node == null)return 0;
        int sum = node.data;
        sum += solve(node.left, target);
        sum += solve(node.right, target);
        if(sum == target)ans++;
        return sum;
    }
}

