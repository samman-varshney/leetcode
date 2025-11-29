class Solution {
    public int totalHammingDistance(int[] nums) {
        int n = nums.length;
        
        int dist = 0;
        for(int i=0; i<32; i++){
            int[] bits = new int[2];
            for(int x: nums){
                bits[(x>>i)&1]++;
            }
            dist += bits[0]*bits[1];
        }
        return dist;

    }
}