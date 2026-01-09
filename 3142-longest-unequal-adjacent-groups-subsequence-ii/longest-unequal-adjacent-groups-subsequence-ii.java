class Solution {

    boolean hamming(String word1, String word2){
        if(word1.length() != word2.length())return false;
        int count = 0;
        for(int i=0; i<word1.length(); i++){
            if(word1.charAt(i) != word2.charAt(i)){
                count++;
            }
            if(count > 1){
                return false;
            }
        }
        return true;
    }
    int n;
    int[][] dp;
    int[] groups;
    String[] words;
    public int helper(int prev, int curr){
        if(curr >= n){
            return 0;
        }

        if(dp[prev+1][curr] != -1){
            return dp[prev+1][curr];
        }
        int pick = 0;
        if(prev == -1 || (hamming(words[prev], words[curr]) && groups[prev] != groups[curr])){
            pick = helper(curr, curr+1)+1;
        }
        int notPick = helper(prev, curr+1);
        return dp[prev+1][curr] = Math.max(pick, notPick);
    }

    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
       
        this.n = groups.length;
        this.groups = groups;
        this.words = words;
        this.dp = new int[n+1][n+1];
        for(int[] x: dp){
            Arrays.fill(x, -1);
        }
        helper(-1, 0);
        List<String> result = new ArrayList<>();
        int i=0, j=0;
        while(i<n && j<n && dp[i][j] != 0){
            int pick = 0;
            if(i == 0 || (hamming(words[i-1], words[j]) && groups[i-1] != groups[j])){
                pick = dp[j+1][j+1]+1;
            }
            int notPick = dp[i][j+1];
            if(pick > notPick){
                result.add(words[j]);
                i = j+1;
            }
            j++;
        }
        return result;
    }
}