class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        int mod = 1_000_000_007;
        int[][][] dp = new int[n][m][k];

        dp[0][0][grid[0][0] % k] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int r = 0; r < k; r++) {
                    if (i == 0 && j == 0) continue;
                    int val = grid[i][j];
                    int fromUp = (i > 0 ? dp[i - 1][j][r] : 0);
                    int fromLeft = (j > 0 ? dp[i][j - 1][r] : 0);
                    int newRem = (r + val) % k;
                    dp[i][j][newRem] = (int)((dp[i][j][newRem] + (long)fromUp + fromLeft) % mod);
                }
            }
        }

        return dp[n - 1][m - 1][0];
    }
}
