class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long sum = 0;
        for(int x : nums){
            sum += x;
        }
        long k = sum%p;
        if( k == 0 ){
            return 0;
        }
    
        int min = Integer.MAX_VALUE;
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, -1);
        sum = 0;
        for(int i=0; i<n; i++){
            sum += nums[i];
            long mod = sum%p;
            if(mod >= k && map.containsKey(mod - k)){
                min = Math.min(min, i - map.get(mod - k));
            }else if(map.containsKey(p + mod - k)){
                min = Math.min(min, i - map.get(p + mod - k));
            }
            map.put(mod, i);
        }
        return min == Integer.MAX_VALUE || min == n ?-1:min;
    }
}