class Solution{
    static int height(int N){
        int sqrt = (int)Math.sqrt(2*N);
        if(sqrt * (sqrt+1) > 2*N)return sqrt-1;
        return sqrt;
    }
}
