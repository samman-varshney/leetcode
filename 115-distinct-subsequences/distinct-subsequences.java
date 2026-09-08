class Solution {

    char[] s, t;
    int[][] dp;
    
    public int numDistinct(String s, String t) {
        this.s = s.toCharArray();
        this.t = t.toCharArray();
        int n = s.length(), m = t.length();
        dp = new int[n][m];
        for(int[] x: dp)
            Arrays.fill(x, -1);

        return helper(n-1, m-1);
    }

    public int helper(int i, int j){
        if(j < 0)return 1;
        if(i < 0)return 0;
        if(dp[i][j] != -1)return dp[i][j];
        int count = 0;
        if(s[i] == t[j])
            count += helper(i-1, j-1);
        
        count += helper(i-1, j);

        return dp[i][j] = count;
    }
}