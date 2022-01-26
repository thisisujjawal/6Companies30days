class Solution {
    public static double ans = 0.0;
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i < n ; i++)graph.add(new ArrayList<>());
        for(int i = 0 ; i < edges.length ; i++){
            graph.get(edges[i][0]).add(i);
            graph.get(edges[i][1]).add(i);
        }
        double dist [] = new double[n];
        Arrays.fill(dist, 0.0);
        dist[start] = 1.0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(start);
        while(!pq.isEmpty()){
            int node = pq.remove();
            ArrayList<Integer> al = graph.get(node);
            for(int idx : al){
                int neigh = edges[idx][0] == node ? edges[idx][1] : edges[idx][0];
                if(succProb[idx]*dist[node] > dist[neigh]){
                    dist[neigh] = dist[node]*succProb[idx];
                    pq.add(neigh);
                }
            }
        }
        return dist[end];
    }
}
