class Solution {
    int mod = (int)1e9 + 7;
    int n;
    long[][] dp;
    public long helper(int i, int arrange){
        if(i >= n){
            return 1;
        }
        if(dp[i][arrange] != -1){
            return dp[i][arrange];
        }
        long notAtAll = 0, bothSide = 0, leftButNtRight =0, rightButNotLeft = 0;

        notAtAll = helper(i+1, 0);
        if(arrange == 0){
            bothSide = helper(i+1, 1);
        }
        if(arrange == 0 || arrange == 3){
            leftButNtRight = helper(i+1, 2);
        }
        if(arrange == 0 || arrange == 2){
            rightButNotLeft = helper(i+1, 3);
        }

        return dp[i][arrange] = (notAtAll + bothSide + leftButNtRight + rightButNotLeft)%mod;

    }
    public int countHousePlacements(int n) {
        this.n = n;
        dp = new long[n][4];
        for(long[] x: dp){
            Arrays.fill(x, -1);
        }
        return (int)helper(0, 0);
    }
}