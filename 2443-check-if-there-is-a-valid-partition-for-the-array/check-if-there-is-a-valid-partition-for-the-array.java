class Solution {
    int n;
    int[] nums;
    int[] dp;
    boolean cond1(int i){
        return i+1 < n && nums[i] == nums[i+1] && helper(i+2);
    }
    boolean cond2(int i){
        return i+2 < n && (nums[i] == nums[i+1] && nums[i+1] == nums[i+2]) && helper(i+3);
    }
    boolean cond3(int i){
        return i+2 < n && (nums[i]+1 == nums[i+1] && nums[i+1]+1 == nums[i+2]) && helper(i+3);
    }
    public boolean helper(int i){
        if(i == n){
            return true;
        }

        if(dp[i] != -1){
            return dp[i] == 1;
        }

        if(cond1(i) || cond2(i) || cond3(i)){
            dp[i] = 1;
            return true;
        }
        dp[i] = 0;
        return false;

    }
    public boolean validPartition(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        this.dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(0);
    }
}