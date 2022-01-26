class Solution {
    public boolean stoneGame(int[] piles) {
        int sum = 0;
        for(int num : piles)sum += num;
        int dp [][] = new int[piles.length][piles.length];
        int alice = solve(piles, 0 , piles.length-1, dp);
        int bob = sum-alice;
        if(alice > bob)return true;
        return false;
    }
    public static int solve(int arr[], int l , int r, int [][] dp){
        if((r-l)+1 < 3){
            return dp[l][r] = Math.max(arr[l],arr[r]);
        }
        if(dp[l][r] != 0)return dp[l][r];
        int a = arr[l] + Math.min(solve(arr,l+2,r,dp),solve(arr,l+1,r-1,dp));
        int b = arr[r] + Math.min(solve(arr,l,r-2,dp),solve(arr,l+1,r-1,dp));
        return dp[l][r] = Math.max(a,b);
    }
}
