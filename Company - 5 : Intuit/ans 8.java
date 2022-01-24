class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int n = points.length;
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            Map<Integer,Integer> map = new HashMap<>();
            for(int j = 0 ; j < n ; j++){
                if(i == j)continue;
                int dist = (int)Math.pow(points[i][0]-points[j][0],2) + 
                    (int)Math.pow(points[i][1]-points[j][1],2);
                map.put(dist, map.getOrDefault(dist,0)+1);
            }
            for(Map.Entry<Integer,Integer> entry : map.entrySet()){
                int val = entry.getValue();
                ans += val*(val-1);
            }
        }
        return ans;
    }
}
