class Solution {
    public int totalHammingDistance(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[32][2];
        for(int i =0 ; i<n; i++){
            for(int j=0; j<32; j++){
                arr[j][(nums[i]>>j)&1]++;
            }
        }
        int dist = 0;
        for(int i=0; i<32; i++){
            dist += arr[i][1]*arr[i][0];
        }
        return dist;
    }
}