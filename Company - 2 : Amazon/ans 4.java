class Solution{
    static String matrixChainOrder(int p[], int n){
        Pair dp [][] = new Pair[n][n];
        Pair pair = solve(p , 0 , n-1, dp);
        return pair.str;
    }
    public static Pair solve(int [] arr, int i , int j, Pair [][] dp){
        if(dp[i][j] != null)return dp[i][j];
        if(j-i == 1){
            Pair ans = new Pair();
            StringBuilder sb = new StringBuilder();
            ans.min = 0;
            ans.str = sb.append((char)(65 + i)).toString();
            return dp[i][j] = ans;
        }else if(j - i == 2){
            Pair ans = new Pair();
            StringBuilder sb = new StringBuilder();
            ans.min = arr[i]*arr[i+1]*arr[i+2];
            sb.append("(");
            sb.append((char)(65+i));
            sb.append((char)(66+i));
            sb.append(")");
            ans.str = sb.toString();
            return dp[i][j] = ans;
        }
        Pair ans = new Pair();
        for(int k = i+1 ; k < j ; k++){
            Pair a = solve(arr, i , k,dp);
            Pair b = solve(arr, k , j,dp);
            int temp = arr[i] * arr[k] * arr[j];
            if(ans.min > temp+a.min + b.min){
                ans.min = temp+a.min+b.min;
                StringBuilder sb = new StringBuilder();
                sb.append("(");
                sb.append(a.str);
                sb.append(b.str);
                sb.append(")");
                ans.str = sb.toString();
            }
        }
        return dp[i][j] = ans;
    }
    public static class Pair{
        int min = Integer.MAX_VALUE;
        String str = "";
    }
}
