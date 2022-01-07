class Solution
{
    public String FirstNonRepeating(String A)
    {
        int [] arr = new int[26];
        int n = A.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n ; i++){
            char c = A.charAt(i);
            if(arr[c-'a'] == 0)arr[c-'a'] = i+1;
            else arr[c-'a'] = Integer.MAX_VALUE;
            int idx = Integer.MAX_VALUE;
            for(int j = 0 ; j < 26 ; j++){
                if(arr[j] != 0)idx = Math.min(idx, arr[j]);
            }
            if(idx == Integer.MAX_VALUE)sb.append("#");
            else sb.append(A.charAt(idx-1));
        }
        return sb.toString();
    }
}
