class GfG
{
	public int missingNumber(String s)
    {
        int n = s.length();
        for(int len = 1 ; len <= 6 ; len++){
            if(len > n)break;
            int num = Integer.valueOf(s.substring(0,len))+1;
            int i = len;
            int adder = len;
            int ans = -1;
            while(i+adder <= n){
                int comp = Integer.valueOf(s.substring(i,i+adder));
                if(comp != num){
                    if(ans == -1){
                        ans = num;
                        num++;
                        adder = length(num);
                    }else break;
                }else{
                    i += adder;
                    num++;
                    adder = length(num);
                }
            }
            if(i >= n && ans != -1)return ans;
        }
        return -1;
    }
    public int length(int num){
        if(num == 0)return 1;
        int count = 0;
        while(num > 0){
            count++;
            num /= 10;
        }
        return count;
    }
}
