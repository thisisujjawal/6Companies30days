class Solution {
    long getNthUglyNo(int n) {
        long two= 2, three = 3 , five = 5;
        int forTwo = 0 , forThree = 0 , forFive = 0;
        long dp [] = new long[n];
        dp[0] = 1;
        for(int i = 1 ; i < n ; i++){
            dp[i] = Math.min(two, Math.min(three, five));
            if(two == dp[i]){
                forTwo++;
                two = 2 * dp[forTwo];
            }
            if(three == dp[i]){
                forThree++;
                three = 3 * dp[forThree];
            }
            if(five == dp[i]){
                forFive++;
                five = 5 * dp[forFive];
            }
        }
        return dp[n-1];
    }
}
