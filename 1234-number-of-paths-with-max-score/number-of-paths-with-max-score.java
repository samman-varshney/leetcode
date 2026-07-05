class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size(), mod = 1000000007;

        int[][] dp = new int[n + 1][n + 1];
        int[][] cnt = new int[n + 1][n + 1];

        cnt[n - 1][n - 1] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                char c = board.get(i).charAt(j);
                if (c == 'X' || (i == n - 1 && j == n - 1)) continue;

                int max = Math.max(dp[i + 1][j], Math.max(dp[i][j + 1], dp[i + 1][j + 1]));

                // if (max == 0 && (i != n - 1 || j != n - 1) 
                // && board.get(i + 1 >= n ? n - 1 : i + 1).charAt(j) != 'S' 
                // && board.get(i).charAt(j + 1 >= n ? n - 1 : j + 1) != 'S' 
                // && board.get(i + 1 >= n ? n - 1 : i + 1).charAt(j + 1 >= n ? n - 1 : j + 1) != 'S') 
                //     continue;

                if (i + 1 < n && dp[i + 1][j] == max)   
                    cnt[i][j] = (cnt[i][j] + cnt[i + 1][j]) % mod;

                if (j + 1 < n && dp[i][j + 1] == max)
                    cnt[i][j] = (cnt[i][j] + cnt[i][j + 1]) % mod;

                if (i + 1 < n && j + 1 < n && dp[i + 1][j + 1] == max)
                    cnt[i][j] = (cnt[i][j] + cnt[i + 1][j + 1]) % mod;

                dp[i][j] = max + (c == 'E' ? 0 : c - '0');
            }
        }
        return cnt[0][0] == 0 ? new int[]{0, 0} : new int[]{dp[0][0], cnt[0][0]};
    }
}
