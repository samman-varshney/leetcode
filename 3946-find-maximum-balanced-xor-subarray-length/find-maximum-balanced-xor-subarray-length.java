class Solution {
    public int maxBalancedSubarray(int[] nums) {
        int n = nums.length;
        HashMap<Long, Integer> map = new HashMap<>();
        map.put((long)n, -1);
        long offset = n;
        long xor = 0, odd= 0, even = 0;
        int res = 0;
        for(int i=0; i<n; i++){
            xor ^= nums[i];
            if(nums[i]%2 == 0){
                even++;
            }else{
                odd++;
            }
            long key = (xor<<32)|(even-odd+offset);
            if(map.containsKey(key)){
                res = Math.max(i - map.get(key), res);
            }else{
                map.put(key, i);
            }
        }
        return res;
    }
}