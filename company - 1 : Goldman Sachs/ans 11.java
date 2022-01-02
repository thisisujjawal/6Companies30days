class Solve {
    int[] findTwoElement(int arr[], int n) {
        int [] ans = new int[2];
        for(int i = 0 ; i < n ; i++){
            int idx = Math.abs(arr[i])-1;
            if(arr[idx] < 0)ans[0] = idx+1;
            arr[idx] = Math.abs(arr[idx])*-1;
        }
        for(int i = 0 ; i < n ; i++){
            if(arr[i] > 0){
                ans[1] = i+1;
                break;
            }
        }
        return ans;
    }
}
