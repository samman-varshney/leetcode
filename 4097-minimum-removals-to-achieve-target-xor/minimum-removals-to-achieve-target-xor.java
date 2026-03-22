class Solution {
    int max = (int)1e9;
    int nums[];
    HashMap<Integer, Integer> map;
    public int minRemovals(int[] nums, int target) {
        this.nums = nums;
        map = new HashMap<>();
        int res = helper(0, target);
        return res==max?-1:res;
    }
    int helper(int i, int target){
        if(i >= nums.length)
            return target == 0?0:max;
        int key = target*100 + i;
        if(map.containsKey(key)){
            return map.get(key);
        }
        int res = Math.min(helper(i+1, target^nums[i]), helper(i+1, target)+1);
        map.put(key, res);
        return res;
    }
}
