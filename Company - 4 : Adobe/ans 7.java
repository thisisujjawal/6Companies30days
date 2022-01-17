class GfG
{
	public static int maxCoins(int A[],int n)
	{
	    int dp [][] = new int[n][n];
	    for(int arr[] : dp)Arrays.fill(arr, -1);
	    solve(A, 0, n-1, dp);
	    return dp[0][n-1];
    }
    public static int solve(int arr [] , int i, int j, int dp[][]){
        if(i == j)return dp[i][j] = arr[i];
        if(j-i == 1){
            return dp[i][j] = Math.max(arr[i], arr[j]);
        }
        if(dp[i][j] != -1)return dp[i][j];
        return dp[i][j] = Math.max(arr[i]+ Math.min(solve(arr,i+2,j,dp),solve(arr,i+1,j-1,dp)) ,
                        arr[j]+ Math.min(solve(arr,i,j-2,dp),solve(arr,i+1,j-1,dp)));
    }
}
