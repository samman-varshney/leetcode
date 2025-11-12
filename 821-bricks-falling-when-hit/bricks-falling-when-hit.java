class Solution {
    int[][] D = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int[] parent, size;
    void union(int u, int v){
        int pu = find(u);
        int pv = find(v);

        if(pu == pv)return;
        if(size[pu] >= size[pv]){
            size[pu]+=size[pv];
            parent[pv] = pu;
        }else{
            size[pv] += size[pu];
            parent[pu] = pv;
        }
    }
    int find(int u){
        if(u == parent[u])
            return u;
        return parent[u] = find(parent[u]);
    }

    int countStable(int[][] copy){
        int n = copy.length, m = copy[0].length;
        int stable = 0;
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=0; i<m; i++){
            // if there is a brick and it ultimate parent it not check then count the group size
            if(copy[0][i] == 1 && !set.contains(find(i))){
                stable += size[find(i)];
                set.add(find(i));
            }
        }

        return stable;
    }
    public int[] hitBricks(int[][] grid, int[][] hits) {

        int n = grid.length, m = grid[0].length;
        parent = new int[n*m];
        size = new int[n*m];
        //initialise parent and size
        for(int i=0; i<size.length; i++){
            parent[i] = i;
            size[i] = 1;
        }

        //create a copy
        int[][] copy = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                copy[i][j] = grid[i][j];
            }
        }

        //perform all the hit operation
        for(int i=0; i<hits.length; i++){
            int x = hits[i][0], y = hits[i][1];
            copy[x][y] = 0;
        }

        //union all the remaining bricks
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(copy[i][j] == 1){
                    for(int[] d : D){
                        int x = i+d[0], y = j+d[1];
                        if(x>=0 && x<n && y>=0 && y<m && copy[x][y] == 1){
                            union(i*m+j, x*m+y);
                        }
                    }
                }
            }
        }

        //count the current stable bricks
        int stable  = countStable(copy);
        int[] res = new int[hits.length];
        for(int i=hits.length-1; i>=0; i--){
            int x = hits[i][0], y = hits[i][1];
            //if there was really a brick there then mark it as 1 and perform other operation
            if(grid[x][y]==1){
                copy[x][y] = 1;
                for(int[] d : D){
                    int row = x+d[0], col = y+d[1];
                    if(row>=0 && row<n && col>=0 && col<m && copy[row][col] == 1){
                        union(x*m+y, row*m+col);
                    }
                }
                int curr = countStable(copy);
                res[i] = curr==stable?0:curr-stable-1;
                stable = curr;
            }
        }
        return res;
    }
}