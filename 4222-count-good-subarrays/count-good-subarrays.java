class Solution {
    public long countGoodSubarrays(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        for(int i=0; i<n; i++){
            int prev = i-1;
            while(prev >= 0 && nums[prev] != nums[i] &&
                  (nums[i]|nums[prev]) == nums[i])
            {
                prev = left[prev];
            }
            left[i] = prev;
        }

        for(int i=n-1; i>=0; i--){
            int next = i+1;
            while(next<n && (nums[i]|nums[next]) == nums[i])
                next = right[next];
            right[i] = next;
        }

        long res = 0;
        for(int i=0; i<n; i++){
            res += (i - left[i]) * (right[i] - i);
        }
        return res;
    }
}