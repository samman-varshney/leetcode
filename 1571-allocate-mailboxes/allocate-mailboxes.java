class Solution {
    long[] prefix, suffix;
    long[][] dp;
    int n;
    int[] nums;
    public long median(int start, int end){
        int med = (start + end)/2;
        long right = prefix[end+1] - prefix[med+1] - nums[med]*(end - med);
        long left = nums[med]*(med - start) - (suffix[start] - suffix[med]);
        return right + left;
    }

    public long helper(int i, int k){
        if(i>=n){
            return 0;
        }
        if(k == 0){
            return Integer.MAX_VALUE;
        }
        if(k == 1){
            return median(i, n-1);
        }

        if(dp[i][k] != -1){
            return dp[i][k];
        }

        long res = Integer.MAX_VALUE;
        for(int j=n-k; j>=i; j--){
            res = Math.min(res, median(i, j)+helper(j+1, k-1));
        }

        return dp[i][k] = res;
        
    }

    public int minDistance(int[] nums, int k) {
        this.nums = nums;
        n = nums.length;
        prefix = new long[n+1];
        suffix = new long[n+1];
        Arrays.sort(nums);
        for(int i=1; i<=n; i++)
            prefix[i] = prefix[i-1] + nums[i-1];
        for(int i=n-1; i>=0; i--)
            suffix[i] = suffix[i+1] + nums[i];
        dp = new long[n][k+1];
        for(long[] x: dp){
            Arrays.fill(x, -1);
        }
        return (int)helper(0, k);

    }
}