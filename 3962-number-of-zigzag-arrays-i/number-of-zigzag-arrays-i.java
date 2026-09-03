class Solution {
    public int zigZagArrays(int n, int l, int r) {
        long[] prefix = new long[r - l + 2];
        for(int i = 0; i<=r - l + 1; i++){
            prefix[i] = i;
        }

        long mod = 1000000007;

        for(int i = n-2; i>=0; i--){
            long[] curr = new long[r - l + 2];
            for(int j = 1; j<=r-l+1; j++){
                curr[j] = (curr[j-1] + ((i&1) == 0? 
                (prefix[r-l+1] - prefix[j] + mod)%mod : prefix[j-1])) %mod;
            }
            prefix = curr;
        }

        return (int)((prefix[r-l+1] * 2) %mod);
    }
}