class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long sum = 0;
        for(int i=0; i<k; i++){
            sum += nums[i];
        }
        long[] prefix = new long[n];
        prefix[k-1] = sum;
        int prev = 0;
        long res = prefix[k-1];
        for(int i =k; i<n; i++){
            sum += nums[i] - nums[prev];
            prefix[i] = sum + (prefix[i - k]<0?0:prefix[i-k]);
            res = Math.max(res, prefix[i]);
            prev++;
        }
        return res;
    }
}