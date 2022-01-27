class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        long mod = (long)(1e9)+7;
        ArrayList<Pair> al = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            al.add(new Pair(speed[i], efficiency[i]));
        }
        Collections.sort(al, (a,b)->{
            return b.eff - a.eff;
        });
        long ans = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            return a.sp - b.sp;
        });
        long sum = 0;
        for(int i = 0 ; i < n ; i++){
            if(pq.size() > k-1){
                Pair temp = pq.remove();
                sum -= temp.sp;
            }
            Pair pair = al.get(i);
            sum += pair.sp;
            ans = Math.max(ans, sum*pair.eff);
            pq.add(pair);
        }
        return (int)(ans%mod);
    }
    public static class Pair{
        int sp, eff;
        Pair(int sp, int eff){
            this.sp = sp;
            this.eff = eff;
        }
    }
}
