class Solution
{
    //Function to find the largest number after k swaps.
    public static String ans = "";
    public static String findMaximumNum(String str, int k)
    {
        ans = str;
        char ch [] = str.toCharArray();
        solve(ch, k);
        return ans;
    }
    public static void solve(char ch [] , int k){
        String tt = String.valueOf(ch);
        if(tt.compareTo(ans) > 0){
            ans = tt;
        }
        if(k == 0)return;
        int n = ch.length;
        for(int i = 0 ; i < n ; i++){
            for(int j = i+1 ; j < n ; j++){
                if(ch[i] < ch[j]){
                    char temp = ch[i];
                    ch[i] = ch[j];
                    ch[j] = temp;
                    solve(ch, k-1);
                    temp = ch[i];
                    ch[i] = ch[j];
                    ch[j] = temp;
                }
            }
        }
    }
}
