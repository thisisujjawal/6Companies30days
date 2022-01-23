class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int l = 0, r = n-1;
        int peek = -1;
        while(l <= r){
            int mid = l+(r-l)/2;
            int left = mountainArr.get(mid-1);
            int right = mountainArr.get(mid+1);
            int center = mountainArr.get(mid);
            if(left < center && center > right){
                peek = mid;
                break;
            }else if(left < center && center < right){
                l = mid;
            }else r = mid;
        }
        int ans = inc(mountainArr, target, 0 , peek);
        if(ans != -1)return ans;
        else ans = dec(mountainArr, target, peek+1, n-1);
        return ans;
    }
    public static int inc(MountainArray arr, int target, int l , int r){
        while(l <= r){
            int mid = l+(r-l)/2;
            int val = arr.get(mid);
            if(val == target){
                return mid;
            }else if(val < target){
                l = mid+1;
            }else r = mid-1;
        }
        return -1;
    }
    public static int dec(MountainArray arr, int target, int l , int r){
        while(l <= r){
            int mid = l+(r-l)/2;
            int val = arr.get(mid);
            if(val == target){
                return mid;
            }else if(val > target){
                l = mid+1;
            }else r = mid-1;
        }
        return -1;
    }
}
