class Solution {
    public int findLengthOfShortestSubarray(int[] nums) {
        int n = nums.length;
        int l = 0, r = n-1;
        while(l+1<n && nums[l+1] >= nums[l])l++;
        while(r>0 && nums[r-1] <= nums[r])r--;

        
        if(r <= l)return 0;
        l++;
        int res = r;
        for(int i=1; i<=Math.min(l, n-1); i++){
            int idx = upperBound(nums, r, n-1, nums[i-1]);
            res = Math.min(res, idx-i);
        }
        return res;
    }

    public int upperBound(int[] nums, int start, int end, int val){
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] >= val){
                end = mid -1;
            }else{
                start = mid+1;
            }
        }
        return start;
    }
}