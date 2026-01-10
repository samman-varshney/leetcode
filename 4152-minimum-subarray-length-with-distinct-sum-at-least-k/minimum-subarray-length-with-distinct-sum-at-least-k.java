class Solution {
    public int minLength(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = Integer.MAX_VALUE;
        int sum = 0;
        int j = 0;
        for(int i=0; i<n; i++){
            if(!map.containsKey(nums[i])){
                sum += nums[i];
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            while(j<=i && sum - (map.get(nums[j]) == 1? nums[j]: 0) >= k){
                map.put(nums[j], map.get(nums[j])-1);
                if(map.get(nums[j]) == 0){
                    map.remove(nums[j]);
                    sum -= nums[j];
                }
                j++;
            }

            if(sum >= k){
                result = Math.min(result, i - j+1);
            }
        }

        return result==Integer.MAX_VALUE?-1:result;
    }
}