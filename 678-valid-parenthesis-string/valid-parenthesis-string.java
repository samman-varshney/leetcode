class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            if(c == '(' || c == '*'){
               st.push(c);
            }else{
                Stack<Character> temp = new Stack<>();
                while(!st.isEmpty() && st.peek() == '*'){
                    temp.push(st.pop());
                }
                if(st.isEmpty() && temp.isEmpty() )return false;
                if(!st.isEmpty())st.pop();else temp.pop();
                while(!temp.isEmpty()){
                    st.push(temp.pop());
                }
            }
        }
        int star = 0;
        while(!st.isEmpty()){
            if(st.pop() == '*'){
                star++;
            }else if(star <= 0){
                return false;
            }else{
                star--;
            }
        }
        return true;
    }
}