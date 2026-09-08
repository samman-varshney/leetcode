class Solution {
    public int distinctSubseqII(String str) {
        int n = str.length();
        char[] s = str.toCharArray();
        long[] dp = new long[n+2];
        int[] lastOccurence = new int[26];
        Arrays.fill(lastOccurence, n);
        dp[n] = 1;
        long mod = 1000000007;

        for(int i=n-1; i>=0; i--){
            dp[i] = (2l * dp[i+1] - dp[lastOccurence[s[i]-'a'] + 1] + mod) %mod;
            lastOccurence[s[i]-'a'] = i;
        }

        for(int i =0; i<=n; i++){
            System.out.println(dp[i]);
        }
        return (int)((dp[0] - 1 + mod) %mod);
    }
}