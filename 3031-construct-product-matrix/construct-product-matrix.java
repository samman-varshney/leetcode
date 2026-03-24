class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        
        int[][] product = new int[n][m];
        long[][] lower = new long[n][m];

        int mod = 12345;

      
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
        long prev = 1;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
               long right = j+1<m?lower[i][j+1]:i+1<n?lower[i+1][0]:1;
                product[i][j] = (int)((prev * right)%mod); 
                prev = (grid[i][j] * prev)%mod;
            }
        }
        return product;
    }
}