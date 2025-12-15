class Solution {
    public long getDescentPeriods(int[] prices) {
        int n = prices.length;
        long[] dp = new long[n];
        Arrays.fill(dp, 1);
        long res = 0;
        for(int i=0; i<n; i++){
            if(i!=0 && prices[i]+1 == prices[i-1]){
                dp[i]+=dp[i-1];
            } 
            res += dp[i];
        }
        return res;
    }
}