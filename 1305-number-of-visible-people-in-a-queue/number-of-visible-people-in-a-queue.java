class Solution {
    public int[] canSeePersonsCount(int[] hts) {
        int n = hts.length;
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && hts[st.peek()] <= hts[i]){
                res[st.pop()]++;
            }
            if(!st.isEmpty()){
                res[st.peek()]++;
            }
            st.push(i);
        }
        return res;
    }
}