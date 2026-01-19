class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        char[] str = s.toCharArray();
        dp = new int[n][n+1];
        for(int[] x: dp){
            Arrays.fill(x, -1);
        }
        return helper(str, 0, 0);
    }
    int[][] dp;
    public boolean helper(char[] s, int i, int o){
        if(i >= s.length)
            return o == 0;
        
        if(o < 0){
            return false;
        }

        if(dp[i][o] != -1){
            return dp[i][o] == 1;
        }
        boolean res = false;
        if(s[i] == '*'){
            res = helper(s, i+1, o+1) || helper(s, i+1, o-1) || helper(s, i+1, o);
        }else{
            res = helper(s, i+1, o+(s[i]=='('?1:-1));
        }
        dp[i][o] = res?1:0;
        return res;
    }
}