class Solution{
    static int minSteps(int D){
        int ans = 1;
        int sum = 0;
        while(sum < D){
            sum += ans;
            ans++;
        }
        while((sum - D)%2 != 0){
            sum+= ans;
            ans++;
        }
        return ans-1;
    }
}
