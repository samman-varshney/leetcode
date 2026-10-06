// class Solution {
//     public int scoreOfParentheses(String s) {
//         int n = s.length();
//         int[] mapping = new int[n];

//         Stack<Integer> st = new Stack<>();
//         for(int i=0; i<n; i++){
//             if(s.charAt(i) == ')'){
//                 mapping[st.pop()] = i;
//             }else{
//                 st.push(i);
//             }
//         }


//     }

//     public int helper(int i, int j){

//         if(i + 1 >= j)
//             return 1;
        
//         int score = 0;
//         int k = i;
//         while(k<=j){
//             score += (j-1==1?1:2)*helper()
//         }
//     }
// }


class Solution {
    public int scoreOfParentheses(String S) {
        int ans = 0, bal = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == '(') {
                bal++;
            } else {
                bal--;
                if (S.charAt(i - 1) == '(') {
                    ans += 1 << bal;
                }
            }
        }
        return ans;
    }
}