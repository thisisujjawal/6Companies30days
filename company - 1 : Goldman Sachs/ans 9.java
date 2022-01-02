class Solution{
    static String printMinNumberForPattern(String S){
        StringBuilder ans = new StringBuilder();
        char ch [] = S.toCharArray();
        int n = ch.length;
        int num = 1;
        int count = 0;
        int i = 0;
        if(ch[0] == 'I'){
            ans.append(num);
            num++;
        }else{
            while(i < n && ch[i] == 'D'){
                count++;
                i++;
            }
            ans.append(count+1);
            num = count+2;
            while(count > 0){
                ans.append(count);
                count--;
            }
        }
        while(i < n){
            if(i+1 < n && ch[i+1] == 'D'){
                i++;
                while(i < n && ch[i] == 'D'){
                    count++;
                    i++;
                }
                ans.append(num+count);
                int temp = (num+count)-1;
                num = num+count+1;
                while(count > 0){
                    ans.append(temp);
                    temp--;
                    count--;
                }
            }else{
                ans.append(num);
                num++;
                i++;
            }
        }
        return ans.toString();
    }
}
