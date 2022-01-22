class Solution {
    public int splitArray(int[] nums, int m) {
        int sum = 0;
        int max = 0;
        for(int n : nums){
            sum += n;
            max = Math.max(max, n);
        }
        int ans = Integer.MAX_VALUE;
        int l = max , r = sum;
        while(l <= r){
            int mid = l+(r-l)/2;
            int temp = solve(nums, mid);
            if(temp > m) l = mid+1;
            else{
                ans = mid;
                r = mid-1;
            }
        }
        return ans;
    }
    public static int solve(int arr[] , int target){
        int ans = 1;
        int sum = 0;
        for(int num : arr){
            if(sum + num > target){
                sum = num;
                ans++;
            }else sum += num;
        }
        return ans;
    }
}
