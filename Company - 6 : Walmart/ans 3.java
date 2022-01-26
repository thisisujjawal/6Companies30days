class Solution {
    public boolean winnerOfGame(String colors) {
        int Alice = 0 , Bob = 0;
        char ch = colors.charAt(0);
        int freq = 0;
        int n = colors.length();
        for(int i = 0 ; i < n ; i++){
            if(ch == colors.charAt(i))freq++;
            else{
                if(ch == 'A'){
                    if(freq > 2)Alice += (freq -2);
                    freq = 1;
                    ch = 'B';
                }else{
                    if(freq > 2)Bob += (freq -2);
                    freq = 1;
                    ch = 'A';
                }
            }
        }
        if(freq > 2){
            if(ch == 'A')Alice += (freq -2);
            else Bob += (freq-2);
        }
        if(Alice > Bob)return true;
        return false;
    }
}
