class Solution {
    public List<List<String>> Anagrams(String[] string_list) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, ArrayList<String>> map  = new HashMap<>();
        int n = string_list.length;
        for(int i = 0 ; i < n ; i++){
            String str = sort(string_list[i]);
            ArrayList<String> al = map.getOrDefault(str, new ArrayList<>());
            al.add(string_list[i]);
            if(al.size() == 1){
                ans.add(al);
            }
            map.put(str, al);
        }
        return ans;
    }
    public static String sort(String str){
        char ch [] = str.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
}
