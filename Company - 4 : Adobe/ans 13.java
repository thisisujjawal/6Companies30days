class Solution {
    static int minInsAndDel(int[] A, int[] B, int N, int M) {
        int ans = 0;
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            if(bs(B,M,A[i])){
                int idx = upperBound(al, A[i]);
                if(idx == -1)al.add(A[i]);
                else al.set(idx, A[i]);
            }
        }
        int n = al.size();
        ans = M-n;
        ans += N-n;
        return ans;
    }
    public static boolean bs(int arr[] , int n , int target){
        int i = 0, j = n-1;
        while(i <= j){
            int mid = (i+j)/2;
            if(arr[mid] == target)return true;
            else if(arr[mid] < target)i = mid+1;
            else j = mid-1;
        }
        return false;
    }
    public static int upperBound(ArrayList<Integer> arr, int target){
        int i = 0 , j = arr.size()-1;
        int ans = -1;
        while(i <= j){
            int mid = (i+j)/2;
            if(arr.get(mid) >= target){
                ans = mid;
                j = mid-1;
            }else i = mid+1;
        }
        return ans;
    }
};
