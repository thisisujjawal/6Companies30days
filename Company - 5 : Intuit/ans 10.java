class Solution {
    public int findCircleNum(int[][] isConnected) {
        int v = isConnected.length;
        int ans = 0;
        boolean visited[] = new boolean[v];
        for(int i = 0 ; i < v ; i++){
            if(!visited[i]){
                ans++;
                solve(isConnected, visited, i);
            }
        }
        return ans;
    }
    public static void solve(int [][] graph, boolean visited [] , int node){
        if(visited[node])return;
        visited[node] = true;
        for(int i = 0 ; i < graph.length ; i++){
            if(graph[node][i] == 1){
                solve(graph, visited, i);
            }
        }
    }
}
