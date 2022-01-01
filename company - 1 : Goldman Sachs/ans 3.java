class Solution {
    
    public int countSubArrayProductLessThanK(long a[], long n, long k)
    {
        long prod = 1;
        int j = 0;
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            while(j < n){
                if(prod * a[j] < k)prod *= a[j];
                else break;
                j++;
            }
            if(j >= n){
                long len = j-i;
                ans += (len*(len+1))/2;
                break;
            }
            ans += (j-i);
            prod /= a[i];
            if(prod == 0){
                prod = 1;
                j++;
            }
        }
        return ans;
    }
}
