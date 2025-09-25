package Dynamic_Programming;

public class LCSBottomUp {
    public static String helper(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        StringBuilder[][] s = new StringBuilder[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            s[i][0] = new StringBuilder();
        }
        for (int i = 0; i <= m; i++) {
            s[0][i] = new StringBuilder();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    s[i][j] = new StringBuilder(s[i - 1][j - 1].toString() + s1.charAt(i - 1));
                } else {
                    int l1 = s[i - 1][j].length();
                    int l2 = s[i][j - 1].length();

                    s[i][j] = new StringBuilder((l1 > l2 ? s[i - 1][j].toString() : s[i][j - 1].toString()));
                }
            }
        }

        return s[n][m].toString();
    }

    public static String solve(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        StringBuilder res = new StringBuilder();
        int row = n, col = m;
        while (row >= 1 && col >= 1) {
            if (s1.charAt(row - 1) == s2.charAt(col - 1)) {
                res.append(s1.charAt(row - 1));
                row--;
                col--;
            } else if (dp[row - 1][col] == dp[row][col]) {
                row--;
            } else {
                col--;
            }
        }

        return res.reverse().toString();
    }


    //further you can implement memoization into it to make it more faster
    public static void dfs(int i, int j, int[][] dp, StringBuilder s, String s1, String s2){
        if(dp[i][j] == 0){
            System.out.println(s.reverse().toString());
            s.reverse();
            return;
        }

        if(s1.charAt(i-1) == s2.charAt(j-1)){
            s.append(s1.charAt(i-1));
            dfs(i-1, j-1, dp, s, s1, s2);
            s.deleteCharAt(s.length()-1);
        }else{
            if(dp[i][j] == dp[i-1][j]){
                dfs(i-1, j, dp, s, s1, s2);
            }
            if(dp[i][j] == dp[i][j-1]){
                dfs(i, j-1, dp, s, s1, s2);
            }
        }
    }

    public static void printAllLCS(String s1, String s2){
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n+1][m+1];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        dfs(n, m, dp, new StringBuilder(), s1, s2);
    }

    public static void main(String[] args) {
        printAllLCS("abcdef", "daebfc");
    }
}
