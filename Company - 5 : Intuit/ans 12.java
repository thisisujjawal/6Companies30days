class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int ans [] = new int[numCourses];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i < numCourses ; i++)graph.add(new ArrayList<>());
        for(int i = 0 ; i < prerequisites.length ; i++){
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        ArrayList<Integer> al = new ArrayList<>();
        boolean visited [] = new boolean[numCourses];
        for(int i = 0 ; i < numCourses ; i++){
            if(!visited[i]){
                boolean temp [] = new boolean[numCourses];
                if(!solve(graph, visited, al, i, temp)) return new int[0];
            }
        }
        for(int i = 0 ; i < numCourses ; i++)ans[i] = al.get(i);
        return ans;
    }
    public static boolean solve(ArrayList<ArrayList<Integer>> graph, boolean visited [] , ArrayList<Integer> al, int node, boolean [] temp){
        if(temp[node]) return false;
        if(visited[node])return true;
        
        visited[node] = true;
        temp[node] = true;
        boolean ans = true;
        ArrayList<Integer> neighbour = graph.get(node);
        for(int neigh : neighbour){
            ans &= solve(graph, visited, al, neigh, temp);
        }
        al.add(node);
        temp[node] = false;
        return ans;
    }
}
