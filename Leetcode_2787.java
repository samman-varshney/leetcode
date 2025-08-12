import java.util.*;
public class Leetcode_2787 {
    int mod = 1000000007;
    public int helper(int tar, int num, int k, int[][] dp){
        if(tar == 0)return 1;
        if(tar < 0 || num > 300)return 0;
        if(dp[tar][num] != -1)return dp[tar][num];
        //take
        return dp[tar][num] = (helper(tar-(int)Math.pow(num, k), num+1, k, dp)%mod + helper(tar, num+1, k, dp)%mod)%mod;
    }
    public int numberOfWays(int n, int x) {
        int[][] dp = new int[n+1][301];
        for(int[] z : dp){
            Arrays.fill(z, -1);
        }
        return helper(n, 1, x, dp);
    }
    public static void main(String[] args) {
       Leetcode_2787 q = new Leetcode_2787();
       System.out.println(q.numberOfWays(300, 1)); 
    }
}
