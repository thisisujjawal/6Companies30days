class Solution{
    static ArrayList<ArrayList<String>> displayContacts(int n, 
                                        String contact[], String s)
    {
        Trie trie = new Trie();
        for(int i = 0 ; i < n ; i++){
            char ch [] = contact[i].toCharArray();
            Trie temp = trie;
            insert(temp, 0 , ch.length , ch);
        }
        char ch [] = s.toCharArray();
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        solve(trie, 0 , ch.length, ch , sb , ans);
        Collections.reverse(ans);
        return ans;
    }
    public static class Trie{
        Trie table [] = new Trie[26];
        int count = 0;
    }
    public static void insert(Trie trie , int i , int n ,char ch[]){
        if(i == n){
            trie.count++;
            return;
        }
        if(trie.table[ch[i] - 'a'] == null){
            Trie temp = new Trie();
            trie.table[ch[i]-'a'] = temp;
        }
        insert(trie.table[ch[i]-'a'] , i+1 , n , ch);
    }
    public static void solve(Trie trie, int i , int n , char ch[], StringBuilder sb, ArrayList<ArrayList<String>> ans){
        if(i == n)return;
        if(trie.table[ch[i]-'a'] == null){
            sb.append("$");
            solve(new Trie() , i+1 , n , ch ,sb, ans);
        }else{
            sb.append(ch[i]);
            solve(trie.table[ch[i]-'a'] , i+1 , n , ch , sb, ans);
        }
        ArrayList<String> al = new ArrayList<>();
        helper(trie.table[ch[i]-'a'], al, sb);
        if(al.isEmpty()){
            al.add("0");
        }
        ans.add(al);
        sb.deleteCharAt(sb.length() - 1);
        
    }
    public static void helper(Trie trie, ArrayList<String> al, StringBuilder sb){
        if(trie == null)return;
        if(trie.count > 0){
            al.add(sb.toString());
        }
        for(int i = 0 ; i < 26 ; i++){
            if(trie.table[i] != null){
                sb.append((char)(i+'a'));
                helper(trie.table[i] , al, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
    
}
