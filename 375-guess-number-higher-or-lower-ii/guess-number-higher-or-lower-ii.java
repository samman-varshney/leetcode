class Solution {
    int[][] dp;
    int helper(int start, int end){
        if(start >= end){
            return 0;
        }
        if(dp[start][end] != -1){
            return dp[start][end];
        }
        int max = (int)1e8;
        for(int i=start; i<=end; i++){
            int res = i + Math.max(helper(start, i-1), helper(i+1, end));
            max = Math.min(max, res);
        }
        return dp[start][end] = max;
    }
    public int getMoneyAmount(int n) {
        dp = new int[n+1][n+1];
        for(int[] x: dp){
            Arrays.fill(x, -1);
        }
        return helper(1, n);
    }
}