class Solution {
    int lengthOfLongestAP(int[] A, int n) {
        if(n == 1 || n == 2)return n;
        int ans = 2;
        int dp [][] = new int[n][10000];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < 10000 ; j++)dp[i][j] = 1;
        }
        for(int i = n-2 ; i >= 0 ; i--){
            for(int j = i+1 ; j < n ; j++){
                int a = A[j]-A[i];
                dp[i][a] = 1 + dp[j][a];
                ans = Math.max(ans, dp[i][a]);
            }
        }
        return ans;
    }
}
