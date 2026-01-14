class Solution {
    int[] nums;
    HashMap<String, Integer> map;
    public int helper(int i, int j, int sum){
        if(i>=j){
            return 0;
        }
        String key = i+" "+j+" "+sum;
        if(map.containsKey(key)){
            return map.get(key);
        }

        //first two
        int first = 0;
        if(sum == -1 || nums[i] + nums[i+1] == sum){
            first = helper(i+2, j, nums[i]+nums[i+1])+1;
        }

        //last two
        int last = 0;
        if(sum == -1 || nums[j-1] + nums[j] == sum){
            last = helper(i, j-2, nums[j-1]+nums[j])+1;
        }

        //first and last
        int fl = 0;
        if(sum == -1 || nums[i]+nums[j] == sum){
            fl = helper(i+1, j-1, nums[i]+nums[j])+1;
        }

        int val = Math.max(fl, Math.max(first, last));
        map.put(key, val);
        return val;
    }
    public int maxOperations(int[] nums) {

        int n = nums.length;
        this.nums = nums;
        this.map = new HashMap<>();
        return helper(0, nums.length-1, -1);
    }
}