class Solution {
    
    public List<String> AllParenthesis(int n) 
    {
        ArrayList<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        solve(0 , 0 , ans, sb, n);
        return ans;
    }
    public void solve(int l, int r, ArrayList<String> ans, StringBuilder sb, int n){
        if(l+r == 2*n){
            ans.add(sb.toString());
            return;
        }
        if(l < n){
            sb.append('(');
            solve(l+1, r, ans, sb, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(r < l){
            sb.append(')');
            solve(l, r+1, ans, sb, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
