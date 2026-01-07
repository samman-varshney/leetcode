class Solution {
    public List<Integer> goodDaysToRobBank(int[] nums, int time) {
        int n = nums.length;
        int[] prefix = new int[n];
        for(int i=1; i<n; i++){
            if(nums[i] <= nums[i-1]){
                prefix[i] += prefix[i-1]+1;
            }
        }
        int[] suffix = new int[n];
        for(int i=n-2; i>=0; i--){
            if(nums[i] <= nums[i+1]){
                suffix[i] += suffix[i+1]+1;
            }
        }

        List<Integer> res = new ArrayList<>();
        for(int i=time; i<n-time; i++){
            int depth = Math.min(prefix[i], suffix[i]);
            if(depth >= time){
                res.add(i);
            }
        }

        return res;
    }
}