class Solution {
    public long isPossible(long[] nums, long k, long cap){
        int  n = nums.length;
        for(int i=0; i<n; i++){
            long diff = nums[i] - Math.min(nums[i], cap);
            k -= diff;
            if(k < 0){
                return -1;
            }
        }
        return k;
    }
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long[] diff = new long[n];
        for(int i=0; i<n; i++){
            diff[i] = Math.abs(nums1[i] - nums2[i]);
        }

        Arrays.sort(diff);
        long start = 0, end = diff[n-1];
        long k = k1+k2;
        long remain = 0;
        while(start <= end){
            long mid = start + (end -start)/2;
            long res = isPossible(diff, k, mid);
            if(res >= 0){
                end = mid-1;
                remain = res;
            }else{
                start = mid+1;
            }
        }
        int j = n-1;
        while(remain-- > 0 && start != 0){
            diff[j--] = start - 1;
        }
        long result = 0;
        for(long x: diff){
            long num = Math.min(start, x);
            result += num*num;
        }
        return result;
    }
}