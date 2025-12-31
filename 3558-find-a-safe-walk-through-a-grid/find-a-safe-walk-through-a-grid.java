class Solution {
    int[][] D = {{-1,0},{0,-1},{1,0},{0,1}};
    int n, m;
    int[][] best; 

    public boolean dfs(int x, int y, int health, List<List<Integer>> grid) {
        if (health <= 0) return false;
        if (x == n - 1 && y == m - 1) return true;

        
        if (best[x][y] >= health) return false;
        best[x][y] = health;

        for (int[] d : D) {
            int row = x + d[0];
            int col = y + d[1];

            if (row >= 0 && row < n && col >= 0 && col < m) {
                if (dfs(row, col, health - grid.get(row).get(col), grid)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        n = grid.size();
        m = grid.get(0).size();
        best = new int[n][m];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                best[i][j] = -1;

        return dfs(0, 0, health - grid.get(0).get(0), grid);
    }
}
