class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
	    int sum = 0;
	    for(int i : arr)sum += i;
	    int temp = sum/2;
	    boolean dp [][] = new boolean[n+1][temp+1];
	    for(int i = 0 ; i <= n ; i++)dp[i][0] = true;
	    for(int i = 1 ; i <= n ; i++){
	        for(int j = 1 ; j <= temp ; j++){
	            if(arr[i-1] <= j && dp[i-1][j-arr[i-1]]){
                   dp[i][j] = true;	                
	            }else{
	                dp[i][j] = dp[i-1][j];
	            }
	        }
	    }
	    for(int i = temp ; i >= 0 ; i--){
	        if(dp[n][i]){
	            return (sum - (2*i));
	        }
	    }
	    return 0;
	} 
}
