class Solution {
    public int maxDepth(String str) {
        char[] s = str.toCharArray();
        Stack<Character> st = new Stack<>();
        int deg = 0;
        for(char c: s){
            if(c!=')' && c!='(')continue;
            if(c==')')
                st.pop();
            else
                st.push(c);
            
            deg = Math.max(st.size(), deg);
        }
        return deg;
    }
}