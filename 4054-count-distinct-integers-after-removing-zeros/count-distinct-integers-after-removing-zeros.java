class Solution {
    public long countDistinct(long num) {
        char[] nums = (""+num).toCharArray();
        int n = nums.length;

        long[] map = new long[n];
        long val = 1;
        long pre = -1;
        for(int i=0; i<n; i++){
            pre += val;
            map[i] = val;
            val *= 9;
        }
        long post = 0;
        for(int i=0; i<n; i++){
            if(nums[i] == '0'){
                break;
            }

            post += (nums[i]-(i==n-1?'0':'1'))*map[n-1-i];
        }

        return pre + post;
    }
}