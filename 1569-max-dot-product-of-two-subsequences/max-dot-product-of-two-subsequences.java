class Solution {
    int n, m;
    int[] nums1, nums2;
    int[][][] dp;
    public int helper(int i, int j, int empty){
        if(i>=n || j>=m){
            return empty == 0? -(int)1e9: 0;
        }
        if(dp[i][j][empty]!=-1){
            return dp[i][j][empty];
        }
        //take both
        int both = nums1[i] * nums2[j] + helper(i+1, j+1, 1);

        //take i but not j
        int iButNotJ = helper(i, j+1, empty);

        //take j but not i
        int jButNotI = helper(i+1, j, empty);

        return dp[i][j][empty] = Math.max(both, Math.max(iButNotJ, jButNotI));
    }
    public int maxDotProduct(int[] nums1, int[] nums2) {
        this.n = nums1.length;
        this.m = nums2.length;
        this.nums1 = nums1;
        this.nums2 = nums2;
        dp = new int[n][m][2];
        for(int[][] x: dp){
            for(int[] y: x){
                Arrays.fill(y, -1);
            }
        }
        return helper(0, 0, 0);
    }
}