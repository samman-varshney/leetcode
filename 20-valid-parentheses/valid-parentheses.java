class Solution {
    public boolean isPair(char c1, char c2){
        switch(c1){
            case '(':return c2==')';
            case '{':return c2=='}';
            case '[':return c2==']';
            default:return false;
        }
    }
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i<s.length(); i++){
            if(!st.isEmpty() && isPair(st.peek(),s.charAt(i)))
                st.pop();
            else
                st.push(s.charAt(i));
        }
        System.out.println(st);
        return st.isEmpty();
    }
}