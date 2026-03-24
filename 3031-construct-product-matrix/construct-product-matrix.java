class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        
        int[][] product = new int[n][m];
        long[][] upper = new long[n][m];
        long[][] lower = new long[n][m];

        int mod = 12345;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(j-1 >= 0)
                    upper[i][j] = (upper[i][j-1] * grid[i][j])%mod;
                else if(i-1 >= 0)
                    upper[i][j] = (upper[i-1][m-1] * grid[i][j])%mod;
                else{
                    upper[i][j] = grid[i][j]%mod;
                }
            }
        }
        for(int i=n-1; i>=0; i--){
            for(int j=m-1; j>=0; j--){
                if(j+1 < m)
                    lower[i][j] = (lower[i][j+1] * grid[i][j])%mod;
                else if(i+1 < n)
                    lower[i][j] = (lower[i+1][0] * grid[i][j])%mod;
                else{
                    lower[i][j] = grid[i][j]%mod;
                }
            }
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
               long left = j-1>=0?upper[i][j-1]:i-1>=0?upper[i-1][m-1]:1;
               long right = j+1<m?lower[i][j+1]:i+1<n?lower[i+1][0]:1;

                product[i][j] = (int)((left * right)%mod); 
            }
        }
        return product;
    }
}