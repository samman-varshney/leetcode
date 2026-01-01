class Solution {
    public int findMaximumXOR(int[] nums) {
        Set<Integer> prefix_set = new HashSet<>();
        int mask = 0;
        int result = 0;
        for(int i=31; i>=0; i--){//32
            mask = mask | (1<<i);
            for(int num: nums){//n
                prefix_set.add(mask&num);
            }

            int temp = result | (1<<i);
            for(int prefix: prefix_set){//n
                if(prefix_set.contains(prefix^temp)){//logn
                    result = temp;
                    break;
                }
            }
            prefix_set.clear();
        }
        return result;
    }
}