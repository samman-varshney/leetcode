class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[][][] dp = new int[n+1][m+1][2];
        for(int i=0; i<=m; i++){
            dp[n][i][0] = -(int)1e9;
            dp[n][i][1] = 0;
        }
        for(int i=0; i<=n; i++){
            dp[i][m][0] = -(int)1e9;
            dp[i][m][1] = 0;
        }

        for(int i=n-1; i>=0; i--){
            for(int j=m-1; j>=0; j--){
                for(int k=1; k>=0; k--){
                    int both = nums1[i] * nums2[j] + dp[i+1][j+1][1];
                    int iButNotJ = dp[i][j+1][k];
                    int jButNotI = dp[i+1][j][k];

                    dp[i][j][k] = Math.max(both, Math.max(iButNotJ,jButNotI));
                }
            }
        }

        return dp[0][0][0];
    }
}