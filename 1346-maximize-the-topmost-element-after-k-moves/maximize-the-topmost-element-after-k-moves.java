class Solution {
    public int maximumTop(int[] nums, int k) {

        int n = nums.length;

        int[][] indices = new int[n][2];

        for(int i=0; i<n; i++){
            indices[i][0] = i;
            indices[i][1] = nums[i];
        }

        Arrays.sort(indices, (a, b)->(b[1] - a[1]));

        for(int i=0; i<n; i++){
            if(k >= indices[i][0]){
                int diff = k - indices[i][0];
                if(diff%2 == 0 || (diff !=1 && (indices[i][0] != n-1 || indices[i][0] != 0))){
                    return indices[i][1];
                }
            }
        }
        return -1;
    }
}