class Solution
{
    String colName (long n)
    {
        StringBuilder sb = new StringBuilder();
        solve(sb, n);
        return sb.toString();
    }
    public static void solve(StringBuilder sb , long n){
        if(n <= 26){
            sb.append((char)('A'+(n-1)));
            return;
        }
        long q = n/26;
        long r = n%26;
        if(q > 0){
            if(r == 0){
                r = 26;
                q--;
            }
            solve(sb, q);
        }else{
            sb.append((char)('A'+(q-1)));
        }
        sb.append((char)('A' + (r-1)));
    }
}
