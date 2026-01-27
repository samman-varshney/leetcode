class Solution {
    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        int n = s.length();
        int[] dp = new int[n+1];
        for(int i=n-1; i>=0; i--){
            dp[i] = (s.charAt(i) == letter? 1: 0) + dp[i+1];
        }
        Stack<Character> st = new Stack<>();
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            while(!st.isEmpty() && st.peek() > c && (k - st.size() + 1) <= (n - i)){
                if(st.peek() == letter){
                    if(dp[i] >= repetition+1)
                        repetition++;
                    else
                        break;
                }
                st.pop();
            }

            if(st.size() < k && (repetition < k - st.size() || c == letter)){
                st.push(c);
                repetition += c == letter? -1: 0;
            }
            
        }

        StringBuilder res = new StringBuilder();
        while(!st.isEmpty()){
            res.append(st.pop());
        }
        return res.reverse().toString();
    }
}