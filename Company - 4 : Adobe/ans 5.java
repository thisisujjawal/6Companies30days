class Solution
{
    static long numOfWays(int n, int x)
    {
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 1 ; i <= n ; i++){
            int power = (int)Math.pow(i,x);
            if(power > n)break;
            al.add(power);
        }
        int k = al.size();
        long dp [][] = new long[k+1][n+1];
        dp[0][0] = 1;
        for(int i = 1 ; i <= k ; i++){
            for(int j = 0 ; j <= n ; j++){
                int num = al.get(i-1);
                dp[i][j] = dp[i-1][j];
                if(num > j)continue;
                dp[i][j] += dp[i-1][j-num];
            }
        }
        return dp[k][n];
    }
}
