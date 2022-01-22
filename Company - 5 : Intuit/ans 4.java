class Solution
{
    //Function to find the largest number after k swaps.
    public static String findMaximumNum(String str, int k)
    {
        char num [] = str.toCharArray();
        return solve(num , k , str , 0 , num.length);
    }
    public static String solve(char[] num , int k, String ans, int idx, int l){
        if(idx >= l || k == 0) {
            for(int i = 0 ; i < l ; i++){
                char ch = ans.charAt(i);
                if(num[i] == ch) continue;
                else if (num[i] > ch){
                    ans = String.valueOf(num);
                    break;
                }else break;
            }
            return ans;
        }
        ans = solve(num , k , ans , idx+1, l);
        for(int i = idx+1 ; i < l ; i++){
            if(num[i] <= num[idx]){
                continue;
            }else{
                swap(i, idx , num);
                ans = solve(num , k-1 , ans , idx+1 , l);
                swap(i, idx , num);
            }
        }
        return ans;
    }
    public static void swap(int x , int y , char [] arr){
        char temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
