class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int ans = 0;
        int idx = 0;
        boolean peak = false;
        for(int i = 1 ; i < n-1 ; i++){
            if(peak){
                if(arr[i] <= arr[i+1]){
                    ans = Math.max(ans, (i-idx)+1);
                    idx = i;
                    peak = false;
                }
            }else{
                if(arr[i] <= arr[i-1]) idx = i;
                else if(arr[i] > arr[i+1])peak = true;
            }
        }
        if(peak)ans = Math.max(ans , (n-idx));
        return ans;
    }
}
