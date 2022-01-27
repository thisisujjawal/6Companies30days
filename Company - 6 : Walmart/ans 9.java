class Solution {
    public int getMoneyAmount(int n) {
        int dp [][] = new int[n+1][n+1];
        return solve(1,n,dp);
    }
    public static int solve(int l , int r, int [][] dp){
        if((r-l) + 1 <= 1)return 0;
        if((r-l) + 1 == 2)return dp[l][r] = l;
        if(dp[l][r] != 0)return dp[l][r];
        int ans = Integer.MAX_VALUE;
        for(int i = l ; i <= r ; i++){
            int left = solve(l, i-1,dp);
            int right = solve(i+1, r,dp);
            ans = Math.min(ans, Math.max(left,right)+i);
        }
        return dp[l][r] = ans;
    }
}
