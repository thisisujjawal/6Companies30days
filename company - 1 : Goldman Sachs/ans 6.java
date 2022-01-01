class Solution {
    public String gcdOfStrings(String str1, String str2) {
        char one [] = str1.toCharArray();
        char two [] = str2.toCharArray();
        int n = one.length;
        int m = two.length;
        int gcd = gcd(n , m);
        boolean found = true;
        int i = 0 , idx = 0;
        while(i < n){
            if(one[i] != one[idx] || one[i] != two[idx]){
                found = false;
                break;
            }
            i++;
            idx++;
            if(idx == gcd)idx = 0;
        }
        if(!found)return "";
        i = 0; idx = 0;
        while(i < m){
            if(two[i] != one[idx] || two[i] != two[idx]){
                found = false;
                break;
            }
            i++;
            idx++;
            if(idx == gcd)idx = 0;
        }
        if(!found)return "";
        return str1.substring(0,gcd);
    }
    public static int gcd(int a , int b){
        if(a == 0)return b;
        return gcd(b%a , a);
    }
}
