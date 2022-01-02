class Solution {
    public boolean canPair(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            int rem = nums[i]%k;
            int req = rem == 0 ? 0 : k - rem;
            int freq = map.getOrDefault(req, 0);
            if(freq == 0)map.put(rem, map.getOrDefault(rem,0)+1);
            else if(freq - 1 == 0)map.remove(req);
            else map.put(req, freq - 1);
        }
        if(map.isEmpty())return true;
        return false;
    }
}
