class Solution {
    public String removeOuterParentheses(String str) {
        char[] s = str.toCharArray();
        Stack<Integer> st = new Stack<>();
        StringBuilder res = new StringBuilder();
        for(int i=0; i<s.length; i++){
            if(s[i] == '('){
                st.push(i);
            }else{
                int j = st.pop();
                if(st.isEmpty()){
                    res.append(str.substring(j+1, i));
                }
            }
        }
        return res.toString();
    }
}