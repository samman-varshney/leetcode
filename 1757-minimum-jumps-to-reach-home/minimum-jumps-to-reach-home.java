class Solution {
    int a, b, x, limit;
    HashSet<Integer> forbidden;
    int[][] dp;
    int[][] visited;
    public boolean isForbidden(int i){
        return forbidden.contains(i);
    }
    public int helper(int i, int row){
        if(i == x){
            return 0;
        }

        if(i < 0 || limit < i || isForbidden(i) || visited[i][row] == 1){
            return (int)1e9;
        }
        visited[i][row] = 1;
        if(dp[i][row] != -1){
            return dp[i][row];
        }
        int forward = helper(i+a, row|1);
        int backward = (int)1e9;
        if(row > 0){
            backward = helper(i - b, 0);
        }
        visited[i][row] = 0;
        return dp[i][row] = Math.min(forward, backward)+1;
    }
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        this.a = a;
        this.b = b;
        this.x = x;
        this.forbidden = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for(int fb: forbidden){
            max = Math.max(max, fb);
            this.forbidden.add(fb);
        }
        this.limit = Math.max(x, max)+a+b;
        this.dp = new int[limit+1][2];
        this.visited = new int[limit+1][2];
        for(int[] y: dp){
            y[0] = y[1] = -1;
        }
        int res = helper(0, 1);
        return res >= (int)1e9 ? -1: res;
    }
}