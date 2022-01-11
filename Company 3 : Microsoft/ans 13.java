class Solution
{
    //Function to find if the given edge is a bridge in graph.
    static int isBridge(int V, ArrayList<ArrayList<Integer>> adj,int c,int d)
    {
        boolean [] isVisited = new boolean[V];
        solve(c , adj, c, d, isVisited);
        if(isVisited[c] && isVisited[d])return 0;
        return 1;
    }
    public static void solve(int node, ArrayList<ArrayList<Integer>> graph, int c , int d , boolean [] isVisited){
        if(isVisited[node])return;
        isVisited[node] = true;
        ArrayList<Integer> neighbour = graph.get(node);
        for(int neigh : neighbour){
            if((node == c && neigh == d )|| (node == d && neigh == c))continue;
            solve(neigh, graph, c, d, isVisited);
        }
    }
}
