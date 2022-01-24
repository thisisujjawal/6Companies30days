class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = 0;
        int sum = 0;
        for(int w : weights){
            max = Math.max(max, w);
            sum += w;
        }
        int l = max, r = sum;
        int ans = 0;
        while(l <= r){
            int mid = l + (r-l)/2;
            int d = cal(weights, mid);
            if(d <= days){
                ans = mid;
                r = mid-1;
            }else l = mid+1;
        }
        return ans;
    }
    public static int cal(int [] arr, int target){
        int ans = 1;
        int sum = 0;
        for(int num : arr){
            if(num+sum > target){
                ans++;
                sum = num;
            }else sum += num;
        }
        return ans;
    }
}
