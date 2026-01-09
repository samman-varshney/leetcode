class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[n][k];

        for(int i=n-1; i>=0; i--){
            for(int j=n-1; j>i; j--){
                int rem = (nums[i]+nums[j])%k;
                dp[i][rem] = 1+dp[j][rem];
            }
        }

        int max = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<k; j++){
                max = Math.max(dp[i][j], max);
            }
        }
        return max+1;
    }
}