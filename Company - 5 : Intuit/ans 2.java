class Solution
{
    public boolean isWordExist(char[][] board, String word)
    {
        int len = word.length();
        int n = board.length;
        int m = board[0].length;
        boolean visited[][] = new boolean[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(board[i][j] == word.charAt(0)){
                    if(solve(board, n, m, 0, len, i, j, visited, word))return true;
                }
            }
        }
        return false;
    }
    public static boolean solve(char board[][], int n, int m, int i, int len, int x , int y, boolean visited[][], String word){
        if(i == len)return true;
        if(x < 0 || y < 0 || x >= n || y >= m || visited[x][y])return false;
        boolean ans = false;
        if(board[x][y] == word.charAt(i)){
            visited[x][y] = true;
            ans |= solve(board, n, m, i+1, len, x+1 , y, visited, word);
            ans |= solve(board, n, m, i+1, len, x, y+1, visited, word);
            ans |= solve(board, n, m, i+1, len, x, y-1, visited, word);
            ans |= solve(board, n, m, i+1, len, x-1 , y, visited, word);
            visited[x][y] = false;
            return ans;
        }else return ans;
    }
}
