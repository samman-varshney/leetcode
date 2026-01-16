class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        for(int i=n-1; i>=0; i--){
            Set<Integer> set = new HashSet<>();
            for(int j = n-1; j>i; j--){
                int key = -(nums[i]+nums[j]);
                if(set.contains(key)){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(key);
                    res.add(temp);
                }
                set.add(nums[j]);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(List<Integer> list: res){
            ans.add(list);
        }
        return ans;
    }
}