class Solution {
    int[][] in = {{2, 3, 4}, {1, 4, 6}, {}, {1, 3, 5}, {2, 5, 6}};
    int[][] grid;
    int[][][] out = {{{0, -1}, {0, 1}}, {{-1, 0}, {1, 0}}, {{0, -1}, {1, 0}}, {{1, 0}, {0, 1}}, {{0, -1}, {-1, 0}}, {{-1, 0}, {0, 1}}};

    boolean isValid(int row, int col, int idx){
        return row >=0 && row < grid.length && col >= 0 && col < grid[0].length && isIn(row, col, idx);
    }
    boolean isIn(int row, int col, int idx){
        int val = grid[row][col];
        for(int x: in[idx]){
            if(x == val){
                return true;
            }
        }
        return false;
    }
    boolean dfs(int x, int y, boolean[][] visited){
        if(x == grid.length-1 && y == grid[0].length-1){
            return true;
        }
        visited[x][y] = true;
        for(int[] d: out[grid[x][y]-1]){
            int idx = 2*d[0] + d[1] + 2;
            int row = x+d[0];
            int col = y+d[1];

            if(isValid(row, col, idx) && !visited[row][col] && dfs(row, col, visited)){
                return true;
            }
        }

        return false;
    }
    public boolean hasValidPath(int[][] grid) {
        this.grid = grid;
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        return dfs(0, 0, visited);
    }
}