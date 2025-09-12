package Dynamic_Programming;
import java.util.*;
public class Leetcode_1043 {
    int[] dp;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            int res = Integer.MIN_VALUE; 
            int max = Integer.MIN_VALUE;
            for (int j = i; j < Math.min(n, i + k); j++) {
                max = Math.max(arr[j], max);
                int sum = (max * (j - i + 1)) + dp[j+1];
                res = Math.max(sum, res);
            }
            dp[i] = res;
        }
        return dp[0];
    }
}
