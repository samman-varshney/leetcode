class Solution {
    int[][] D = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    boolean isInvalid(int i, int j, int n, int m){
        return i<0 || i>=n || j<0 || j>=m;
    }
   boolean dfs(int i, int j, int[][] grid){
    if(isInvalid(i, j, grid.length, grid[0].length))
        return false;

    if(grid[i][j] == 1)
        return true;

    grid[i][j] = 1;

    boolean isClosed = true;
    for(int[] d: D){
        int x = i + d[0];
        int y = j + d[1];
        isClosed &= dfs(x, y, grid);
    }

    return isClosed;
}



    public int closedIsland(int[][] grid) {
        int res = 0;
        int n = grid.length, m = grid[0].length;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 0){
                    if(dfs(i, j, grid)){
                        res++;
                    }
                }
            }
        }
        return res;
    }
}