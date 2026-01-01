class Solution {
    public int maximumStrongPairXor(int[] nums) {
        int n = nums.length;
        int result = 0;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(Math.abs(nums[i] - nums[j]) <= Math.min(nums[i], nums[j])){
                    result = Math.max(result, nums[i]^nums[j]);
                }
            }
        }
        return result;
    }
}