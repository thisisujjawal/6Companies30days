class Solution {
    public boolean isPossible(int N, int[][] prerequisites)
    {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i < N ; i++)graph.add(new ArrayList<>());
        for(int i = 0 ; i < prerequisites.length ; i++){
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int [] visited = new int[N];
        //0-> unvisited, 1 -> permanently visited, 2-> currently visited
        for(int i = 0 ; i < N ; i++){
            if(visited[i] == 0){
                boolean temp = cyclic(graph, i , visited);
                if(temp)return false;
            }
        }
        return true;
    }
    public static boolean cyclic(ArrayList<ArrayList<Integer>> graph, int node, int [] visited){
        if(visited[node] == 2)return true;
        if(visited[node] == 1)return false;
        visited[node] = 2;
        ArrayList<Integer> neighbour = graph.get(node);
        boolean ans = false;
        for(int neigh : neighbour){
            ans = ans || cyclic(graph, neigh , visited);
        }
        visited[node] = 1;
        return ans;
    }
    
}
