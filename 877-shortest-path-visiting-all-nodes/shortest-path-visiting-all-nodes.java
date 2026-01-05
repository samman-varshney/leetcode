class Solution {
    int[][] visited;
    int[][] dp;
    int finalMask;
    int[][] graph;

    public int shortestPathLength(int[][] graph) {

        int n = graph.length;
        finalMask = (1<<n)-1;
        visited = new int[n][n];
        dp = new int[n][finalMask+1];
        this.graph = graph;

        int res = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            for(int[] x: dp){
                Arrays.fill(x, -1);
            }
            res = Math.min(res, dfs(i, 0|(1<<i)));
        }
        return res;
    }

    public int dfs(int node, int mask){
        
        if(mask == finalMask){
            return 0;
        }
        if(dp[node][mask] != -1){
            return dp[node][mask];
        }

        int min = (int)1e9;

        for(int nbr: graph[node]){
            if(visited[node][nbr] == 0){
                visited[node][nbr] = 1;
                int res = dfs(nbr, mask|(1<<nbr));
                min = Math.min(res, min);
                visited[node][nbr] = 0;
            }
        }
       
        return dp[node][mask] = min+1;
    }
}