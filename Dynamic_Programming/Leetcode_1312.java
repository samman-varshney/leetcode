package Dynamic_Programming;

public class Leetcode_1312 {
        public int helper(String s){
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        String rev = (new StringBuilder(s)).reverse().toString();
        for(int i=0; i<=n; i++){
            dp[0][i] = i;
            dp[i][0] = i;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(s.charAt(i-1) == rev.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1])+1;
                }
            }
        }

        return dp[n][n]/2;
    }
}
