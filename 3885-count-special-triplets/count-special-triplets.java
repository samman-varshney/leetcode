class Solution {
    public int specialTriplets(int[] nums) {
        int n = nums.length;
        int mod = (int)1e9+7;

        HashMap<Integer, Integer> map = new HashMap<>();
        int left[] = new int[n];

        for(int i=0; i<n; i++){
            if(map.containsKey(nums[i]*2)){
                left[i] = map.get(nums[i]*2);
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        } 

        map.clear();
        long res = 0;

        for(int i=n-1; i>=0; i--){
            int right = map.get(nums[i]*2) == null ? 0: map.get(nums[i]*2);

            res = (res + (left[i] * 1L * right)%mod)%mod;
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        return (int)res;
    }
}