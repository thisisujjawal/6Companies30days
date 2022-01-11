class Solution
{
    public String findOrder(String [] dict, int N, int K)
    {
        StringBuilder sb = new StringBuilder();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i < K ; i++)graph.add(new ArrayList<>());
        for(int i = 1 ; i < N ; i++){
            String a = dict[i-1];
            String b = dict[i];
            int n = a.length();
            int m = b.length();
            for(int j = 0 ; j < Math.min(n,m) ; j++){
                if(a.charAt(j) != b.charAt(j)){
                    ArrayList<Integer> al = graph.get(a.charAt(j) - 'a');
                    al.add(b.charAt(j) - 'a');
                    break;
                }
            }
        }
        boolean visited [] = new boolean[K];
        for(int i = 0 ; i < K ; i++){
            if(!visited[i])solve(sb, visited, i, graph);
        }
        return sb.reverse().toString();
    }
    public static void solve(StringBuilder sb, boolean visited[] , int node, ArrayList<ArrayList<Integer>> graph){
        if(visited[node])return;
        visited[node] = true;
        ArrayList<Integer> neighbour = graph.get(node);
        for(int neigh : neighbour){
            solve(sb, visited, neigh, graph);
        }
        sb.append((char)('a' + node));
    }
}
