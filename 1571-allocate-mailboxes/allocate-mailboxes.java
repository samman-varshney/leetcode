class Solution {
    int n;
    int[] nums;
    long[] prefix, suffix;

    // cost of serving [l..r] with 1 mailbox
    long cost(int l, int r) {
        int m = (l + r) >> 1;
        long left = (long) nums[m] * (m - l) - (suffix[l] - suffix[m]);
        long right = (prefix[r + 1] - prefix[m + 1]) - (long) nums[m] * (r - m);
        return left + right;
    }

    // returns {totalCost, mailboxCount}
    long[] solve(long lambda) {
        long[] dp = new long[n + 1];
        int[] cnt = new int[n + 1];

        Arrays.fill(dp, (long) 1e18);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                long val = dp[j] + cost(j, i - 1) + lambda;
                if (val < dp[i]) {
                    dp[i] = val;
                    cnt[i] = cnt[j] + 1;
                }
            }
        }
        return new long[]{dp[n], cnt[n]};
    }

    public int minDistance(int[] houses, int k) {
        nums = houses;
        Arrays.sort(nums);
        n = nums.length;

        prefix = new long[n + 1];
        suffix = new long[n + 1];

        for (int i = 1; i <= n; i++)
            prefix[i] = prefix[i - 1] + nums[i - 1];

        for (int i = n - 1; i >= 0; i--)
            suffix[i] = suffix[i + 1] + nums[i];

        long lo = 0, hi = (long) 1e12;
        while (lo < hi) {
            long mid = (lo + hi) >> 1;
            long[] res = solve(mid);
            if (res[1] > k) lo = mid + 1;
            else hi = mid;
        }

        long[] finalRes = solve(lo);
        return (int) (finalRes[0] - lo * k);
    }
}
