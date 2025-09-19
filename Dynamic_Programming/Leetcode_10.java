package Dynamic_Programming;
import java.util.*;

public class Leetcode_10 {
    class Solution {

    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        StringBuilder pat = new StringBuilder();
        for(int i=0; i<m; i++){

        }
        
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<s.length();i++)
            for(int j=0;j<p.length();j++)
                dp[i][j] =-1;
        
        for(int i=0; i<m; i++){
            int j = i;
            int countAst = 0;
            int remain = m - j;
            while(j < m){
                if(p.charAt(j) == '*'){
                    countAst++;
                }
                j++;
            }

            dp[n][i] = (2*countAst == remain)? 1: 0;
        }

    

        for(int i=n-1; i>=0; i--){
            for(int j=m-1; j>=0; j--){

                boolean nextAst = j<m-1 && p.charAt(j+1) == '*';

                if(nextAst){
                
                    boolean skip = dp[i][j+2] == 1;
                    if(skip){
                        dp[i][j] = 1;
                        break;
                    }
                    for(int k=i; k<n && (s.charAt(k) == p.charAt(j) || p.charAt(j) == '.'); k++){
                        boolean res = dp[k+1][j+2] == 1;
                        if(res){
                            dp[i][j] = 1;
                            break;
                        }
                    }
                }else{
                    if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'){
                        boolean res = dp[i+1][j+1] ==1;
                        dp[i][j] = res? 1: 0;
                        break;
                    }
                }
                dp[i][j] = 0;
            }
        }
        
        return dp[0][0] == 1;
    }
}
}
