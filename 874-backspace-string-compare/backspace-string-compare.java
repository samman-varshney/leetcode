class Solution {
    public String helper(String str){
        char[] s = str.toCharArray();
        Stack<Character> st = new Stack<>();
        for(char c: s){
            if(c != '#'){
                st.push(c);
            }else if(!st.isEmpty()){
                st.pop();
            }
        }

        StringBuilder res = new StringBuilder();
        while(!st.isEmpty()){
            res.append(st.pop());
        }
        
        return res.reverse().toString();
    }
    public boolean backspaceCompare(String s, String t) {
        String parsedS = helper(s);
        String parsedT = helper(t);

        return parsedS.equals(parsedT);
    }
}