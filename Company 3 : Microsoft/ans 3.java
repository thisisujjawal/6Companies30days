class GFG
{
    static void rotate(int matrix[][]) 
    {
        int n = matrix.length;
        for(int i = 0 ; i < n ; i++){
            int idx = i;
            int jdx = 0;
            for(int te = 0 ; te < (i+1)/2 ; te++){
                int temp = matrix[idx][jdx];
                matrix[idx][jdx] = matrix[jdx][idx];
                matrix[jdx][idx] = temp;
                idx--;jdx++;
            }
        }
        for(int i = 1 ; i < n ; i++){
            int idx = n-1;
            int jdx = i;
            for(int te = 0 ; te < (n-i)/2 ; te++){
                int temp = matrix[idx][jdx];
                matrix[idx][jdx] = matrix[jdx][idx];
                matrix[jdx][idx] = temp;
                idx--;jdx++;
            }
        }
        for(int i = 0 ; i < n ; i++){
            int idx = 0, jdx = n-1;
            while(idx < jdx){
                int temp = matrix[idx][i];
                matrix[idx][i] = matrix[jdx][i];
                matrix[jdx][i] = temp;
                idx++;jdx--;
            }
        }
    }
}
