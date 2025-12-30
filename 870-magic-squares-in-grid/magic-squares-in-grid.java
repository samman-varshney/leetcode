class Solution { 
    public boolean isMagicSquare(int x, int y, int[][] grid){

        //checking if 1-9 are present
        boolean[] set = new boolean[10];

        for(int i=x; i<x+3; i++){
            for(int j=y; j<y+3; j++){
                if(grid[i][j] > 9 || set[grid[i][j]]){
                    return false;
                }
                set[grid[i][j]] = true;
            }
        }

        for(int i=1; i<10; i++){
            if(!set[i])
                return false;
        }

        int required = 0;
        for(int i=x; i<x+3; i++){
            required += grid[i][y];
        }

        //columns
        for(int i=y; i<y+3; i++){
            int sum = 0;
            for(int j=x; j<x+3; j++){
                sum += grid[j][i];
            }
            if(sum != required){
                return false;
            }
        }

        //rows
        for(int i=x; i<x+3; i++){
            int sum = 0;
            for(int j=y; j<y+3; j++){
                sum += grid[i][j];
            }
            if(sum != required){
                return false;
            }
        }

        //left diagonal
        if((grid[x][y]+grid[x+1][y+1]+grid[x+2][y+2]) != required)
            return false;
        
        //right diagonal
        if((grid[x][y+2]+grid[x+1][y+1]+grid[x+2][y])!=required)
            return false;
        
        return true;
    }

    public int numMagicSquaresInside(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int count = 0;
        for(int i=0; i<=n-3; i++){
            for(int j=0; j<=m-3; j++){
                if(isMagicSquare(i, j, grid)){
                    count++;
                }
            }
        }
        return count;
    }
}