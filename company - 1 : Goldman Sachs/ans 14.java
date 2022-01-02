class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int n = nums.length;
        int arr [] = new int[n];
        arr[0] = nums[0];
        for(int i = 1 ; i < n ; i++)arr[i] = arr[i-1]+nums[i];
        if(arr[n-1] < target)return 0;
        
        int i = 0 , j = 0;
        while(j < n){
            if(arr[j] >= target){
                while(arr[j] - arr[i] >= target)i++;
                ans = Math.min(ans , (j-i)+1);
            }
            j++;
        }
        return ans;
    }
}
