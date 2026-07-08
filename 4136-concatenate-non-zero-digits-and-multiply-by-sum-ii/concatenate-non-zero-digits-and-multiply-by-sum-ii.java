class Solution {
    public int[] sumAndMultiply(String str, int[][] queries) {
        int n = str.length();
        char[] arr = str.toCharArray();
        int mod = 1000000007;

        int[] sum = new int[n+1];
        int[] index = new int[n+1];

        StringBuilder s = new StringBuilder();

        for(int i = 0; i < n; i++){
            if(arr[i] != '0'){
                s.append(arr[i]);
                index[i+1] = index[i] + 1;
            } else {
                index[i+1] = index[i];
            }
            sum[i+1] = sum[i] + (arr[i] - '0');
        }

        int m = s.length();
        
        long[] hash = new long[m+1];
        long[] pow10 = new long[m+1];
        pow10[0] = 1;

        for(int i = 1; i <= m; i++){
            hash[i] = (hash[i-1] * 10 + (s.charAt(i-1) - '0')) % mod;
            pow10[i] = (pow10[i-1] * 10) % mod;
        }

        int q = queries.length;
        int[] ans = new int[q];

        for(int i = 0; i < q; i++){
            int l = queries[i][0], r = queries[i][1];

            int L = index[l];
            int R = index[r+1];
            int len = R - L;

            long x = (hash[R] - (hash[L] * pow10[len]) % mod + mod) % mod;
            int digSum = sum[r+1] - sum[l];

            ans[i] = (int)((x * digSum) % mod);
        }

        return ans;
    }
}
