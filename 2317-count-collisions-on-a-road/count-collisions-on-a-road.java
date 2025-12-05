class Solution {
    public int countCollisions(String d) {
        Stack<Character> st = new Stack<>();
        int res = 0;
        for(int i=0; i<d.length(); i++){
            char curr = d.charAt(i);

            if( curr == 'R' ){
                st.push(curr);
            }else{
                while(!st.isEmpty()){
                    char prev = st.pop();
                    if(prev == 'R'){
                        res += curr=='L'?2:1;
                        curr = 'S';
                    }else{
                        res += curr=='L'?1:0;
                        curr = 'S';
                    }
                }
                if(curr!='L')st.push(curr);
            }
        }
        return res;
    }
}