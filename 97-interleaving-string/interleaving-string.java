class Solution {
    char[] s1, s2, s3;
    int n, m;
    int[][][] dp;
    public boolean helper(int i, int j, int k){
        if(i >= n || j >= m){

            if(i>=n && (m-j != m+n - k)){
                return false;
            }else if(j>=m && (n-i != m+n - k))
                return false;  
            
            char[] temp = i>=n?s2:s1;
            int start = i>=n?j:i;
            int end = i>=n?m:n;

            for(int x=0; x<end-start; x++){
                if(s3[k+x]!=temp[start+x])
                    return false;
            }

            return true;
        }

        if(k>=n+m || (s3[k]!=s1[i] && s3[k]!=s2[j]))
            return false;

        if(dp[i][j][k] != -1)
            return dp[i][j][k] == 1;

        boolean pheli = false;
        if(s3[k] == s1[i]){
            pheli = helper(i+1, j, k+1);
        }
        if(pheli){
            dp[i][j][k] = 1;
            return true;
        }

        boolean dusri = false;
        if(s3[k] == s2[j]){
            dusri = helper(i, j+1, k+1);
        }
        dp[i][j][k] = dusri?1:0;
        return dusri;
        
    }
    public boolean isInterleave(String str1, String str2, String str3) {
        s1 = str1.toCharArray();
        s2 = str2.toCharArray();
        s3 = str3.toCharArray();

        n = s1.length; m = s2.length;
        if(n+m != s3.length)
            return false;
        
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for(int i=0; i<n; i++)freq1[s1[i]-'a']++;
        for(int i=0; i<m; i++)freq1[s2[i]-'a']++;
        for(int i=0; i<n+m; i++)freq2[s3[i]-'a']++;

        for(int i=0; i<26; i++){
            if(freq1[i] != freq2[i])
                return false;
        }
        dp = new int[n+1][m+1][n+m+1];
        for(int[][] x: dp){
            for(int[] y: x){
                Arrays.fill(y, -1);
            }
        }
        return helper(0, 0, 0);
    }
}