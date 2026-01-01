class Solution {
    public int findMaximumXOR(int[] nums) {
        HashSet<Integer> prefix_set = new HashSet<>();
        int mask = 0;
        int result = 0;
        for(int i=31; i>=0; i--){
            mask = mask | (1<<i);
            for(int num: nums){
                prefix_set.add(mask&num);
            }

            int temp = result | (1<<i);
            for(int prefix: prefix_set){
                if(prefix_set.contains(prefix^temp)){
                    result = temp;
                    break;
                }
            }
            prefix_set.clear();
        }
        return result;
    }
}