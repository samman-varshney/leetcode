class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] freq = new int[100000];
        Arrays.fill(freq, -1);

        int res = Integer.MIN_VALUE;
        for(int i=n-1; i>=0; i--){
            int next = freq[arr[i]+difference+20000];
            if(next != -1){
                dp[i] = dp[next]+1;
            }
            freq[arr[i]+20000] = i;
            res = Math.max(dp[i], res);
        }

        return res;
    }
}