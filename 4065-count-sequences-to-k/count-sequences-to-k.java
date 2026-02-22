class Solution {
    int[] nums;
    long k;
    int n;
    HashMap<String, Integer> map;
    public int helper(int i, long nr, long dr){
        if(i >= n){
            return nr%dr == 0 && nr/dr == k? 1:0;
        }

        String key = i + " " + nr + " " + dr;
        if(map.containsKey(key)){
            return map.get(key);
        }

        int multiple = helper(i+1, nr*nums[i], dr);
        int divide = helper(i+1, nr, dr*nums[i]);
        int leave = helper(i+1, nr, dr);

        int ways = multiple + divide + leave;
        map.put(key, ways);
        return ways;
    }
    public int countSequences(int[] nums, long k) {
        this.nums = nums;
        this.k = k;
        this.n = nums.length;
        this.map = new HashMap<>();
       
        return helper(0, 1, 1);
    }
}