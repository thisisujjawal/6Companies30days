class Solution {
    static int findPosition(int N , int M , int K) {
        int ans = M%N;
        if(ans == 0)ans = N;
        ans += (K-1);
        ans = ans%N;
        if(ans == 0)return N;
        return ans;
    }
};
