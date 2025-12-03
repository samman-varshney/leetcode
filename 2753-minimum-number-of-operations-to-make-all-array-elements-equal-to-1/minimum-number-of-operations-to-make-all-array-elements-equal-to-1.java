class Solution {
    int GCD(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        // If both are zero, GCD is undefined; return 0 as a safe default
        if (a == 0 && b == 0) {
            return 0;
        }

        // Euclidean algorithm (iterative)
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public int minOperations(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        
        int one = 0;
        int gcd = 0;
        for(int i=0;i<n; i++){
            dp[i][i] = nums[i];
            gcd = GCD(gcd, nums[i]);
            one += nums[i]==1?1:0;
        }

        if(gcd != 1){
            return -1;
        }
        if(one!=0){
            return n-one;
        }

        int minOp = n;
        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                dp[i][j] = GCD(dp[i-1][j], nums[i]);
                if(dp[i][j] == 1)minOp = Math.min(minOp, i-j);
            }
        }

        return minOp + n - 1;
    }
}