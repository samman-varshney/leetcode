class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int n = s.length();
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            if(c == '('){
                st.push(i);
            }else if(!st.isEmpty() && s.charAt(st.peek()) == '('){
                st.pop();
            }else{
                st.push(i);
            }
        }
        
        int maxlen = 0;
        int prev = n;
        while(!st.isEmpty()){
            int curr = st.pop();
            maxlen = Math.max(maxlen, prev - curr - 1);
            prev = curr;
        }

        return Math.max(maxlen, prev);
    }
}