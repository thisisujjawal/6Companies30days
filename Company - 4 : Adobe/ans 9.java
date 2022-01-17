class Solution
{
    public String nextPalin(String N) 
    {
        int n = N.length();
        if(n < 4)return "-1";
        char ans [] = new char[n];
        int idx = -1;
        if((n&1) == 1)ans[n/2] = N.charAt(n/2);
        int arr [] = new int[10];
        for(int i = 0 ; i < n/2 ; i++)arr[N.charAt(i)-'0']++;
        
        for(int i = (n/2)-1 ; i>= 0 ; i--){
            if(i == 0)break;
            char a = N.charAt(i);
            char b = N.charAt(i-1);
            if(a > b){
                for(int j = 0 ; j < i-1 ; j++){
                    ans[j] = ans[(n-1)-j] = N.charAt(j);
                    arr[N.charAt(j)-'0']--;
                }
                idx = i-1;
                int j = (b-'0') + 1;
                while(j < 10){
                    if(arr[j] != 0)break;
                    j++;
                }
                ans[i-1] = ans[n-i] = (char)(j + '0');
                arr[j]--;
                break;
            }
        }
        if(idx == -1)return "-1";
        else{
            idx++;
            for(int i = 0 ; i < 10 ; i++){
                while(arr[i] > 0){
                    arr[i]--;
                    ans[idx] = ans[(n-1)-idx] = (char)(i+'0');
                    idx++;
                }
            }
        }
        return String.valueOf(ans);
    }
}
