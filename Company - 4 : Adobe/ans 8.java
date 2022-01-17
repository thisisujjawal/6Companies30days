class Solution
{
    int atoi(String str) {
        int ans = 0;
        int n = str.length();
        boolean neg = false;
        for(int i = 0 ; i < n ; i++){
            int c = str.charAt(i);
            if(i == 0 && c == '-'){
                neg = true;
                continue;
            }
            if(c >= '0' && c <= '9'){
                ans += (c-'0');
                ans *= 10;
            }else return -1;
        }
        if(neg)ans *= -1;
        return ans/10;
    }
}
