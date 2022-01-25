class Solution {
    public Node construct(int[][] grid) {
        int n = grid.length;
        return solve(grid, 0, 0, n);
    }
    public static Node solve(int[][] grid, int x, int y, int len){
        if(len <= 1){
            return new Node(grid[x][y] == 1 ? true : false ,true);
        }
        int area = 0;
        for(int i = x ; i < x+len ; i++){
            for(int j = y ; j < y+len ; j++){
                area += grid[i][j];
            }
        }
        if(area == len*len || area == 0){
            return new Node(area == 0 ? false : true,true);
        }else{
            len /= 2;
            Node a = solve(grid, x, y, len);
            Node b = solve(grid, x, y+len, len);
            Node c = solve(grid, x+len, y, len);
            Node d = solve(grid, x+len, y+len, len);
            return new Node(true,false,a,b,c,d);
        }
    }
}
