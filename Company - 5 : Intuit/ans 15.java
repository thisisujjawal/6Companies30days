class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = 0;
        for(int num : piles)max = Math.max(max, num);
        int l = 1, r = max;
        int ans = 0;
        while(l <= r){
            int mid = l+(r-l)/2;
            int temp = solve(piles, mid);
            if(temp <= h){
                r = mid-1;
                ans = mid;
            }else l = mid+1;
        }
        return ans;
    }
    public static int solve(int arr[] , int target){
        int ans = 0;
        int sum = 0;
        for(int num : arr){
            ans += num/target;
            if(num%target != 0)ans++;
        }
        return ans;
    }
}
