class Solution {
    static int maxProfit(int K, int N, int A[]) {
        int dp [][] = new int[K+1][N+1];
        for(int i = 1 ; i <= K ; i++){
            int max = Integer.MIN_VALUE;
            for(int j = 1 ; j <= N ; j++){
                if(j > 1)max = Math.max(max , dp[i-1][j-1] - A[j-2]);
                dp[i][j] = Math.max(dp[i][j-1] , max + A[j-1]); 
            }
        }
        return dp[K][N];
    }
}
