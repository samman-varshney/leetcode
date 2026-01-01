class Solution {
    public int maximumTop(int[] nums, int k) {
        int n = nums.length;
        if(n == 1 && k%2 == 1){
            return -1;
        }
        int max = -1;
        for(int i=0; i<Math.min(n, k+1); i++){
            if(max < nums[i] && (k-i)!=1){
                    max = nums[i];
            }
        }
        return max;
    }
}