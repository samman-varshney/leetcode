
class Solution {
    long[][] dp;
    long[] pref;
    int n;
    long inf = (long) 1e18;
   public long minPartitionScore(int[] nums, int k) {
        n = nums.length;

        pref = new long[n + 1];
        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + nums[i];
        }

        dp = new long[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return dfs(nums, k, 0);
    }

    public long dfs(int[] nums, int k, int idx) {
        if (idx == n && k == 0) return 0;
        if (idx == n || k == 0) return inf;

        if (dp[idx][k] != -1) return dp[idx][k];

        long ans = inf;

        for (int i = idx; i <= n - k; i++) {
            long curr = pref[i + 1] - pref[idx]; 
            long cost = curr * (curr + 1) / 2;
            
             if (cost >= ans) break;
            ans = Math.min(ans, cost + dfs(nums, k - 1, i + 1));
        }

        return dp[idx][k] = ans;
    }
}