class Solution {
    public int hammingWeight(int n) {
        int ones = 0;
        for(int i=0; i<32; i++){
            ones += ((n>>i)&1);
        }
        return ones;
    }
}