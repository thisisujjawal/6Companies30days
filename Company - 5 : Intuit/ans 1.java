class Solution
{

	public int minDifference(int arr[], int n) 
	{
	    int sum = 0;
	    for(int num : arr)sum += num;
	    int temp = sum;
	    sum /= 2;
	    boolean dp [][] = new boolean[n+1][sum+1];
	    for(int i = 0 ; i <= n ; i++) dp[i][0] = true;
	    for(int i = 1 ; i<= n ; i++){
	        for(int j = 1 ; j <= sum ; j++){
	            dp[i][j] = dp[i-1][j];
	            if(j >= arr[i-1])dp[i][j] |= dp[i-1][j-arr[i-1]];
	        }
	    }
	    int idx = sum;
	    while(idx >= 0){
	        if(dp[n][idx])break;
	        idx--;
	    }
	    return temp - (idx*2);
	} 
}
