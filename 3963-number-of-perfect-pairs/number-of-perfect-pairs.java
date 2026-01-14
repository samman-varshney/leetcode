class Solution {
    public int upperbound(int[] nums, int val){
        int n = nums.length;
        int start  = 0, end = n-1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] >= val){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return start;
    }
    public long perfectPairs(int[] nums) {
        int n = nums.length;
        int[] absolute = new int[n];
        for(int i=0; i<n; i++){
            absolute[i] = nums[i]<0?-nums[i]:nums[i];
        }

        Arrays.sort(absolute);
        long res = 0;
        for(int i=n-1; i>0; i--){
            int j = upperbound(absolute, (absolute[i]+1)/2);
            res += i - j;
        }
        return res;
    }
}