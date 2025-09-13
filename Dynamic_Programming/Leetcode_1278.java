package Dynamic_Programming;

import java.util.Arrays;

public class Leetcode_1278 {
    class Solution {
    int[][] dp;
    int[][] palindrome;
    int n;
    public int helper(int idx, int k){
        if(k == 1){
            return palindrome[idx][n-1];
        }
        if(dp[idx][k] != -1){
            return dp[idx][k];
        }
        int cost = n;
        for(int i=idx; i<n-k+1; i++){
            int res = helper(i+1, k-1)+palindrome[idx][i];
            cost = Math.min(res, cost);
        }
        return dp[idx][k] = cost;
    }
    public int palindromePartition(String s, int k) {

        n = s.length();
 
        palindrome = new int[n][n];
        for(int l = 2; l<=n; l++){
            for(int i=0; i<n-l+1; i++){
                int j = i+l-1;
                palindrome[i][j] = palindrome[i+1][j-1] + (s.charAt(i) == s.charAt(j) ? 0:1);
            }
        }
        dp = new int[n][k+1];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        return helper(0, k);
    }
}
}
