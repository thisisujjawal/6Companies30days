class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, (String a, String b)->{
            int n = a.length();
            int m = b.length();
            if(m > n)return 1;
            else if(n > m)return -1;
            else if(a.equals(b))return 0;
            else{
                for(int i = 0 ; i < n ; i++){
                    int x = a.charAt(i);
                    int y = b.charAt(i);
                    if(x != y){
                        if(x > y)return -1;
                        else return 1;
                    }
                }
            }
            return 0;
        });
        return nums[k-1];
    }
}
