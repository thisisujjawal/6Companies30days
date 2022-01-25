class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        for(int i = 0 ; i < n ; i++){
            int j = n-1;
            while(j >= 0 && grid[i][j] == 0)j--;
            // if(j == -1)j++;
            grid[i][0] = j;
        }
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            int idx = -1;
            int j = n-1;
            while(j >= i){
                if(grid[j][0] <= i){
                    idx = j;
                }
                j--;
            }
            if(idx == -1)return -1;
            while(idx > i){
                ans++;
                swap(grid, idx, idx-1);
                idx--;
            }
        }
        return ans;
    }
    public static void swap(int arr[][] , int i , int j){
        int temp = arr[i][0];
        arr[i][0] = arr[j][0];
        arr[j][0] = temp;
    }
}
