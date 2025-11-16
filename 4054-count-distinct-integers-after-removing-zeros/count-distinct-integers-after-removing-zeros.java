class Solution {
    public long countDistinct(long num) {
        char[] nums = (""+num).toCharArray();
        int n = nums.length;

        HashMap<Integer, Long> map = new HashMap<>();
        long val = 1;
        long pre = -1;
        for(int i=0; i<n; i++){
            pre += val;
            map.put(i, val);
            val *= 9;
        }
        long post = 0;
        for(int i=0; i<n; i++){
            if(nums[i] == '0'){
                break;
            }

            post += (nums[i]-(i==n-1?'0':'1'))*map.get(n-1-i);
        }

        return pre + post;
    }
}