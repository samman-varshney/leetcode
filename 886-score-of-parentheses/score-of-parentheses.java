class Solution {
    public int scoreOfParentheses(String s) {
        int n = s.length();
        int[] mapping = new int[n];

        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            if(s.charAt(i) == ')'){
                mapping[st.pop()] = i;
            }else{
                st.push(i);
            }
        }

        return (int)helper(0, s.length()-1, mapping);
    }

    public double helper(int i, int j, int[] mapping){
        if(i > j)
            return 0.5;
        
        double score = 0;
        int k = i;
        while(k<=j){
            score += 2 * helper(k+1, mapping[k]-1, mapping);
            k = mapping[k]+1;
        }

        return score;
    }
}
  