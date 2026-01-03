class Solution {
    int[][] combinations;
    int[][] dp;
    int mod = (int)1e9+7;
    int n;

    public boolean validCombination(int i, int j){
        return combinations[i][0]!=combinations[j][0] 
        && combinations[i][1]!=combinations[j][1]
        && combinations[i][2]!=combinations[j][2];
    }

    public int helper(int i, int j){
        if(i >= n-1){
            return 1;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int result = 0;
        for(int k=0; k<12; k++){
            if(validCombination(j, k)){
                result = (result + helper(i+1, k))%mod;
            }
        }
        return dp[i][j] = result;
    }

    public int numOfWays(int n) {
        this.n = n;
        combinations = new int[12][3];
        int l = 0;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(i == j)continue;
                for(int k=0; k<3; k++){
                    if(k == j)continue;
                    combinations[l++] = new int[]{i, j, k};
                }
            }
        }
        dp = new int[n][12];
        for(int[] x: dp){
            Arrays.fill(x, -1);
        }

        int result = 0;
        for(int i=0; i<12; i++){
            result  = (result + helper(0, i))%mod;
        }
        return result;
    }
}