class Solution
{
    //Function to return the name of candidate that received maximum votes.
    public static String[] winner(String arr[], int n)
    {
        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
        int max = 0;
        String str [] = new String[2];
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            int freq = entry.getValue();
            String s = entry.getKey();
            if(freq > max){
                max = freq;
                str[0] = s;
            }else if(freq == max && s.compareTo(str[0]) < 0){
                str[0] = s;
            }
        }
        str[1] = max + "";
        return str;
    }
}

