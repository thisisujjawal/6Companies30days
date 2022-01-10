class Solution
{
    //Function to find unit area of the largest region of 1s.
    public int findMaxArea(int[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1){
                    ans = Math.max(ans, solve(grid, i, j , n , m));
                }
            }
        }
        return ans;
    }
    public static int solve(int [][] matrix, int x , int y , int n, int m){
        if(x < 0 || y < 0 || x >= n || y >= m || matrix[x][y] != 1)return 0;
        matrix[x][y] = 2;
        int a [] = {1,0,-1,0,1,1,-1,-1};
        int b [] = {0,1,0,-1,1,-1, -1,1};
        int ans = 0;
        for(int i = 0 ; i < 8 ; i++){
            ans += solve(matrix, x+a[i], y+b[i], n , m);
        }
        return ans+1;
    }
}
