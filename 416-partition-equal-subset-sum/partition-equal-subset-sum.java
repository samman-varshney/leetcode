class Solution {
    int n;
    int[] nums;
    int[][] dp;
    public boolean helper(int i, int target){
        if(target == 0){
            return true;
        }

        if(i >= n || target < 0){
            return false;
        }

        if(dp[i][target] != -1)return dp[i][target] == 1;
 
        boolean res = helper(i+1, target-nums[i]) || helper(i+1, target);
        dp[i][target] = res?1:0;
        return res;
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums){
            sum += num;
        }

        if(sum%2 == 1){
            return  false;
        }
        
        this.n = nums.length;
        this.nums = nums;
        this.dp = new int[n][sum/2+1];
        for(int[] x: dp)
            Arrays.fill(x, -1);

        return helper(0, sum/2);
    }
}