class Solution {
    public int scoreOfParentheses(String s) {
        int ans = 0, bal = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                bal++;
            }else{
                bal--;
                if(s.charAt(i-1) == '(')
                    ans += 1 << bal;
            }
        }

        return ans;
    }
}