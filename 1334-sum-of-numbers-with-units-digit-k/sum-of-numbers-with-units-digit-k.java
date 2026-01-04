class Solution {
    int n;
    int[] arr;
    int[][] dp;
    public int helper(int i, int tar){
        if(tar == 0){
            return 0;
        }

        if(tar < 0 || i >= n){
            return (int)1e9;
        }

        if(dp[i][tar] != -1){
            return dp[i][tar];
        }

        int pick = helper(i, tar - arr[i])+1;
        int notPick = helper(i+1, tar);

        return dp[i][tar] = Math.min(pick, notPick);
    }
    public int minimumNumbers(int num, int k) {
        if(num == 0)return 0;

        this.n = (num+9)/10;
        this.arr = new int[n];
        arr[0] = k==0?10:k;

        for(int i=1; i<n; i++){
            arr[i] = arr[i-1]+10;
        }

        this.dp = new int[n][num+1];
        for(int[] x: dp){
            Arrays.fill(x, -1);
        }

        int res = helper(0, num);
        return res >= (int)1e9 ? -1: res;
    }
}