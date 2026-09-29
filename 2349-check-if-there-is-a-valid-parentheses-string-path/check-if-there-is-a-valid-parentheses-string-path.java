class Solution {
    int n, m;
    char[][] grid;
    int[][][] dp;
    public boolean hasValidPath(char[][] grid) {

        n = grid.length; m = grid[0].length;
        this.grid = grid;

        if(grid[0][0] == ')' || grid[n-1][m-1] == '(' || ((n + m - 1)&1) == 1)
            return false;
        dp = new int[n][m][n+m];
        for(int[][] x: dp){
            for(int[] y: x){
                Arrays.fill(y, -1);
            }
        }
        return helper(0, 0, 1) == 1;
    }

    public int helper(int i, int j, int k){
        if(k < 0)return 0;

        if(i == n-1 && j == m-1)return k==0?1:0;
        if(dp[i][j][k] != -1)return dp[i][j][k];
        
        if(i+1 < n){
            if(helper(i+1, j, k + (grid[i+1][j] == ')'?-1:1)) == 1)
                return dp[i][j][k] = 1;
        }

        return dp[i][j][k] = (j+1 < m ? helper(i, j+1, k + (grid[i][j+1] == ')'?-1:1)): 0);
    }
}
