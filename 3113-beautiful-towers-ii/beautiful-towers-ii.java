class Solution {
    public long maximumSumOfHeights(List<Integer> hts) {
        int n = hts.size();
        Stack<Integer> st = new Stack<>();
        long[] left = new long[n];
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && hts.get(st.peek()) > hts.get(i))
                st.pop();
            
            if(st.isEmpty()){
                left[i] = hts.get(i)*(i+1L);
            }else{
                left[i] = left[st.peek()] + hts.get(i)*1L*(i - st.peek());
            }
            st.push(i);
        }
        st.clear();
        long[] right = new long[n];
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && hts.get(st.peek()) > hts.get(i))
                st.pop();
            
            if(st.isEmpty()){
                right[i] = hts.get(i)*1L*(n - i);
            }else{
                right[i] = right[st.peek()] + hts.get(i)*1L*(st.peek() - i);
            }
            st.push(i);
        }

        // System.out.println(Arrays.toString(left));
        // System.out.println(Arrays.toString(right));

        long res = 0;
        for(int i=0; i<n; i++){
            res = Math.max(res, left[i]+right[i]-hts.get(i));
        }
        return res;
    }
}