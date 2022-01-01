class Solution
{
    public int CountWays(String str)
    {
        char ch [] = str.toCharArray();
        int n = ch.length;
        long dp [] = new long[n+1];
        dp[0] = 1;
        long mod = (long)(1e9)+7;
        for(int i = 1 ; i <= n ; i++){
            int num = ch[i-1]-'0';
            if(num != 0){
                dp[i] = dp[i-1];
                if(i-2 >= 0 && ch[i-2] != '0'){
                    num = ((ch[i-2]-'0')*10)+(ch[i-1]-'0');
                    if(num > 0 && num < 27)dp[i] = (dp[i] + dp[i-2])%mod;
                }
            }else{
                if(i-2 >= 0 && ch[i-2] != '0'){
                   num = ((ch[i-2]-'0')*10)+(ch[i-1]-'0');
                    if(num > 0 && num < 27)dp[i] = (dp[i] + dp[i-2])%mod;
                    else return 0;
                }else return 0;
            }
        }
        return (int)dp[n];
    }
}
