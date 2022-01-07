class Solution{
    static int isValid(int mat[][]){
        for(int i = 0 ; i < 9 ; i++){
            Set<Integer> a = new HashSet<>();
            Set<Integer> b = new HashSet<>();
            for(int j = 0 ; j < 9 ; j++){
                if(mat[i][j] != 0){
                    if(!a.add(mat[i][j]))return 0;
                }
                if(mat[j][i] != 0){
                    if(!b.add(mat[j][i]))return 0;
                }
                if(i%3 == 0 && j%3 == 0){
                    Set<Integer> set = new HashSet<>();
                    for(int idx = i ; idx < i+3 ; idx++){
                        for(int jdx = j ; jdx < j+3 ; jdx++){
                            if(mat[idx][jdx] != 0){
                                if(!set.add(mat[idx][jdx]))return 0;
                            }
                        }
                    }
                }
            }
        }
        return 1;
    }
}
