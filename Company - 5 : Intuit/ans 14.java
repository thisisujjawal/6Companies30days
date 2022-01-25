class Solution {
    public int maxDistance(int[][] grid) {
        int ans = -1;
        int n = grid.length;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ;  j < n ; j++){
                if(grid[i][j] == 0){
                    Queue<Pair> queue = new LinkedList<>();
                    queue.offer(new Pair(i,j));
                    int temp = -1;
                    boolean visited [][] = new boolean[n][n];
                    visited[i][j] = true;
                    while(!queue.isEmpty()){
                        Pair pair = queue.poll();
                        visited[pair.x][pair.y] = true;
                        if(grid[pair.x][pair.y] == 1){
                            temp = Math.abs(pair.x - i) + Math.abs(pair.y - j);
                            break;
                        }else{
                            if(pair.x - 1 >= 0 && !visited[pair.x-1][pair.y]){
                                queue.offer(new Pair(pair.x-1,pair.y));
                                visited[pair.x-1][pair.y] = true;
                            }
                            if(pair.y - 1 >= 0 && !visited[pair.x][pair.y-1]){
                                queue.offer(new Pair(pair.x, pair.y -1));
                                visited[pair.x][pair.y-1] = true;
                            }
                            if(pair.x+1 < n && !visited[pair.x+1][pair.y]){
                                queue.offer(new Pair(pair.x+1, pair.y));
                                visited[pair.x+1][pair.y] = true;
                            }
                            if(pair.y+1 < n && !visited[pair.x][pair.y+1]){
                                queue.offer(new Pair(pair.x, pair.y+1));
                                visited[pair.x][pair.y+1] = true;
                            }
                        }
                    }
                    ans = Math.max(ans,temp);
                }
            }
        }
        return ans;
    }
    public class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
