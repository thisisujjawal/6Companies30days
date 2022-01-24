class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        boolean visited [][] = new boolean[n][m];
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                boolean checker[] = new boolean[2];
                solve(heights, n, m, i, j, checker, visited, heights[i][j]);
                if(checker[0] && checker[1]){
                    List<Integer> al = new ArrayList<>();
                    al.add(i);
                    al.add(j);
                    ans.add(al);
                }
            } 
        }
        return ans;
    }
    public static void solve(int arr[][], int n, int m, int x, int y, boolean [] checker, boolean [][] visited, int height){
        if(x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || arr[x][y] > height)return;
        if(x == 0 || y == 0)checker[0] = true;
        if(x == n-1 || y == m-1)checker[1] = true;
        visited[x][y] = true;
        int v [] = {1,0,-1,0};
        int h [] = {0,1,0,-1};
        for(int i = 0 ; i < 4 ; i++){
            if(checker[0] && checker[1])break;
            solve(arr, n, m, x+v[i], y+h[i], checker, visited, arr[x][y]);
        }
        visited[x][y] = false;
    }
}
