class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 2){
                    queue.offer(new Pair(i,j));
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int x = pair.x;
            int y = pair.y;
            //left
            if(isValid(x,y-1,n,m) && grid[x][y-1] == 1){
                grid[x][y-1] = grid[x][y] + 1;
                queue.offer(new Pair(x , y-1));
                ans = Math.max(grid[x][y-1] , ans);
            }
            //right
            if(isValid(x,y+1,n,m) && grid[x][y+1] == 1){
                grid[x][y+1] = grid[x][y] + 1;
                queue.offer(new Pair(x , y+1));
                ans = Math.max(grid[x][y+1] , ans);
            }
            //up
            if(isValid(x-1,y,n,m) && grid[x-1][y] == 1){
                grid[x-1][y] = grid[x][y] + 1;
                queue.offer(new Pair(x-1, y));
                ans = Math.max(grid[x-1][y] , ans);
            }
            //down
            if(isValid(x+1,y,n,m) && grid[x+1][y] == 1){
                grid[x+1][y] = grid[x][y] + 1;
                queue.offer(new Pair(x+1, y));
                ans = Math.max(grid[x+1][y] , ans);
            }
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        if(ans == Integer.MIN_VALUE)return 0;
        return ans-2;
    }
    public static class Pair{
        int x , y;
        Pair(int x , int y){
            this.x = x;
            this.y = y;
        }
    }
    public static boolean isValid(int x , int y , int n , int m){
        if(x < 0 || y < 0 || x >= n || y >= m)return false;
        return true;
    }
}
