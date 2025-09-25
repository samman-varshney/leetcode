package Dynamic_Programming;

public class LongestCommonSubString{
    public static int helper(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int res = 0;
        int[][] dp = new int[n+1][m+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
     System.out.println(helper("abcjklp", "acjkp"));
    }
}