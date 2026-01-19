class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int x: nums){
            xor ^= x;
        }
        int diff = xor&(-xor);
        int[] res = {0, 0};
        for(int x: nums){
            if((x&diff) != 0){
                res[0] ^= x;
            }else{
                res[1] ^= x;
            }
        }
        return res;
    }
}