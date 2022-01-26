class Solution
{
    //Function to find total number of unique paths.
    public static int NumberOfPath(int a, int b) 
    {
        int [][] arr = new int[a][b];
        return solve(arr, a, b, 0 , 0 , 0);
    }
    public static int solve(int arr[][], int n, int m, int x, int y, int ans){
        if(x >= n || y >= m)return ans;
        if(x == n-1 && y == m-1)return ans+1;
        ans = solve(arr,n,m,x+1,y,ans);
        ans = solve(arr,n,m,x,y+1,ans);
        return ans;
    }
}
