class Solution {
    int n, m;
    int[][] grid;
    int[][] dp;
    int[][] D = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int dfs(int x, int y){
        if(dp[x][y] != -1)
            return dp[x][y];
        int path = 0;
        for(int[] d : D){
            int row = x+d[0];
            int col = y+d[1];

            if(row>=0 && row<n && col >=0 && col <m && grid[row][col] > grid[x][y]){
                path = Math.max(path, dfs(row, col));
            }
        }
        return dp[x][y] = path + 1;
    }
    public int longestIncreasingPath(int[][] matrix) {
        this.grid = matrix;
        this.n = matrix.length;
        this.m = matrix[0].length;
        this.dp = new int[n][m];
        for(int[] x: dp){
            Arrays.fill(x, -1);
        }
        int res = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int path = dfs(i, j);
                res = Math.max(path, res);
            }
        }
        return res;
    }
}