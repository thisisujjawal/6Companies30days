class Solution
{
    //Function to find list of all words possible by pressing given numbers.
    static ArrayList <String> possibleWords(int a[], int N)
    {
        ArrayList<String> ans = new ArrayList<>();
        char ch [][] = {
            {'a','b','c'},
            {'d','e','f'},
            {'g','h','i'},
            {'j','k','l'},
            {'m','n','o'},
            {'p','q','r','s'},
            {'t','u','v'},
            {'w','x','y','z'},
        };
        StringBuilder sb = new StringBuilder();
        solve(ans,a, 0 , ch, sb);
        return ans;
    }
    static void solve(ArrayList<String>ans,int arr [] , int idx , char [][] ch, StringBuilder sb){
        if(idx == arr.length){
            ans.add(sb.toString());
            return;
        }
        int n = ch[arr[idx]-2].length;
        for(int i = 0 ; i < n ; i++){
            sb.append(ch[arr[idx]-2][i]);
            solve(ans , arr , idx+1 , ch , sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
