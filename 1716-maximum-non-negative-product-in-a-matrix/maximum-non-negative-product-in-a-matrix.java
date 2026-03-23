class Solution {
    public int maxProductPath(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int mod = (int)1e9+7;
        long[][] max = new long[n][m];
        long[][] min = new long[n][m];

        min[n-1][m-1] = grid[n-1][m-1];
        max[n-1][m-1] = grid[n-1][m-1];
        //bottom row
        for(int i=m-2; i>=0; i--){
            max[n-1][i] = min[n-1][i] = max[n-1][i+1] * grid[n-1][i];
        }
        //right most column
        for(int i=n-2; i>=0; i--){
            max[i][m-1] = min[i][m-1] = max[i+1][m-1] * grid[i][m-1];
        }
        for(int i=n-2; i>=0; i--){
            for(int j=m-2; j>=0; j--){
                //right
                long rax = max[i][j+1] * grid[i][j];
                long rin = min[i][j+1] * grid[i][j];

                //down
                long dax = max[i+1][j] * grid[i][j];
                long din = min[i+1][j] * grid[i][j];

                max[i][j] = Math.max(Math.max(rax, rin), Math.max(dax, din));
                min[i][j] = Math.min(Math.min(rax, rin), Math.min(dax, din));
            }
        }

        if(max[0][0] < 0)
            return -1;
        return (int)(max[0][0]%mod);
    }
}