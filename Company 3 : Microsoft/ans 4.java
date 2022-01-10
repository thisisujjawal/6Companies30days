class Solution
{
    //Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < Math.min((r+1)/2 , (c+1)/2) ; i++){
            solve(ans, matrix, r, c, i);
        }
        return ans;
    }
    public static void solve(ArrayList<Integer> ans, int [][] matrix, int r, int c, int reduce){
        //right
        if(1+reduce == c-reduce)ans.add(matrix[reduce][(c-1)-reduce]);
        else if(1+ reduce <= c-reduce){
            for(int i = reduce ; i < c-reduce ; i++){
                ans.add(matrix[reduce][i]);
            }
        }
        //down
        if(1+reduce < r-reduce){
            if(2+reduce == r-reduce)ans.add(matrix[reduce+1][(c-1)-reduce]);
            else if(2+ reduce < r-reduce){
                for(int i = 1+reduce ; i < r-reduce ; i++){
                    ans.add(matrix[i][(c-1)-reduce]);
                }
            }
        }
        //left
        if(1+reduce < r-reduce){
            if((c-1)-reduce == 1+reduce)ans.add(matrix[(r-1)-reduce][(c-2)-reduce]);
            else if((c-1)-reduce > 1+reduce){
                for(int i = (c-2)-reduce ; i >= reduce ; i--){
                    ans.add(matrix[(r-1)-reduce][i]);
                }
            }
        }
        //up
        if(1+reduce < c-reduce){
            if((r-1)-reduce == 2+reduce)ans.add(matrix[(r-2)-reduce][reduce]);
            else if((r-1)-reduce > 2+reduce){
                for(int i = (r-2)-reduce ; i >= reduce+1 ; i--){
                    ans.add(matrix[i][reduce]);
                }
            }
        }
    }
}
