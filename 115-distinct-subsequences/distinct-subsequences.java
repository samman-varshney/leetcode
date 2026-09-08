class Solution {

    public int numDistinct(String str, String tr) {
        int n = str.length(), m = tr.length();
        if(m > n)return 0;

        char[] s = str.toCharArray();
        char[] t = tr.toCharArray();

        int[][] dp = new int[n+1][m+1];
        for(int i=0; i<=n; i++){
            dp[i][0] = 1;
        }


        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(s[i] == t[j]){
                    dp[i+1][j+1] += dp[i][j];
                }
                dp[i+1][j+1] += dp[i][j+1];
            }   
        }

        return dp[n][m];
    }
}