class Solution {

    boolean cond1(int n, int[] nums, int i, boolean[] dp){
        return i+1 < n && nums[i] == nums[i+1] && dp[i+2];
    }
    boolean cond2(int n, int[] nums, int i, boolean[] dp){
        return i+2 < n && (nums[i] == nums[i+1] && nums[i+1] == nums[i+2]) && dp[i+3];
    }
    boolean cond3(int n, int[] nums, int i, boolean[] dp){
        return i+2 < n && (nums[i]+1 == nums[i+1] && nums[i+1]+1 == nums[i+2]) && dp[i+3];
    }

    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n+1];
        Arrays.fill(dp, false);
        dp[n] = true;
        
        for(int i=n-1; i>=0; i--){
            if(cond1(n, nums, i, dp) || cond2(n, nums, i, dp) || cond3(n, nums, i, dp)){
                dp[i] = true;
            }
        }
        return dp[0];
    }
}