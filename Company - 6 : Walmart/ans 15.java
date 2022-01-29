class Solution {
    public int divide(int dividend, int divisor) {
        int ans = 0;
        if(dividend == Integer.MIN_VALUE && divisor == -1)return Integer.MAX_VALUE;
        if(dividend == Integer.MIN_VALUE && divisor == Integer.MIN_VALUE)return 1;
        if(divisor == Integer.MIN_VALUE)return 0;
        if(dividend == Integer.MIN_VALUE){
            ans++;
            dividend += Math.abs(divisor);
        }
        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        while(a >= b){
            int num = b;
            int mul = 1;
            boolean temp = true;
            while(num <= a){
                if((num << 1) < 0){
                    temp = false;
                    break;
                }
                num <<= 1;
                mul <<= 1;
            }
            if(temp)mul >>= 1;
            ans += (mul);
            if(temp)num >>= 1;
            a -= num;
        }
        if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) ans *= -1;
        return ans;
    }
}
