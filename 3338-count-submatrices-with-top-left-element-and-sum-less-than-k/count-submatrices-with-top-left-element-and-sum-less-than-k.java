class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        long[][] prefix = new long[n+1][m+1];
        long[][] vertical = new long[n+1][m+1];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                vertical[i][j] = vertical[i-1][j] + grid[i-1][j-1];
                prefix[i][j] = vertical[i][j] + prefix[i][j-1];
            }
        }

        int count = 0;
        for(int i=0; i<n; i++){
            if(prefix[i+1][1] > k)break;
            for(int j=0; j<m; j++){
                if(prefix[i+1][j+1] > k)break;
                count++;
            }
        }
        return count;
    }
}