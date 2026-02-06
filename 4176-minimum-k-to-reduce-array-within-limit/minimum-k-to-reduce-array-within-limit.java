class Solution {
    public long nonPositive(int[] nums, long k){
        long ops = 0;
        for(int num: nums){
            ops += (num + k - 1)/k;
        }
        return ops;
    }
    public int minimumK(int[] nums) {
        
        int n = nums.length;
        long sum = 0;
        for(int num: nums){
            sum += num;
        }
        long start = 1, end = sum;

        while(start <= end){
            long mid = start + (end - start)/2;
            if(nonPositive(nums, mid) <= mid*mid){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return (int)start;
    }
}