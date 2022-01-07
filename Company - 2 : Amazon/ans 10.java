class Solution {
    void matchPairs(char nuts[], char bolts[], int n) {
        quick(nuts, 0 , n-1);
        quick(bolts, 0 , n-1);
    }
    void quick(char ch[], int i , int j){
        if(i >= j)return;
        int idx = i-1;
        int jdx = i;
        while(jdx < j){
            if(ch[jdx] < ch[j]){
                idx++;
                char temp = ch[jdx];
                ch[jdx] = ch[idx];
                ch[idx] = temp;
            }
            jdx++;
        }
        idx++;
        char temp = ch[j];
        ch[j] = ch[idx];
        ch[idx] = temp;
        quick(ch , i , idx-1);
        quick(ch , idx+1 , j);
    }
}
