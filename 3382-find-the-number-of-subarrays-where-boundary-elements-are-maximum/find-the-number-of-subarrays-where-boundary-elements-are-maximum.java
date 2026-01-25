class Solution {
    public long numberOfSubarrays(int[] nums) {
        int n = nums.length;
        long left[] = new long[n];
        long res = 0;
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            left[i] = 1;
            while(!st.isEmpty() && nums[st.peek()] < nums[i]){
                st.pop();
            }
            if(!st.isEmpty() && nums[st.peek()] == nums[i]){
                left[i] += left[st.pop()];
            }
            res += left[i];
            st.push(i);
        }
        return res;
      
    }
}