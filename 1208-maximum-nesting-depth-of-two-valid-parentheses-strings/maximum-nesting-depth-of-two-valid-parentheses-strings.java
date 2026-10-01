class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        char[] s = seq.toCharArray();
        Stack<Integer> st = new Stack<>();
        int deg = 0;
        int[] mapping = new int[n];
        
        for(int i=0; i<s.length; i++){
            if(s[i]==')')
                mapping[st.pop()] = i;
            else
                st.push(i);
            
            deg = Math.max(deg, st.size());
        }

        int maxRing = (deg+1)/2;

        int[] res = new int[n];
        int i = 0;
        while(i < n){
            if(s[i] == '(')
                maxRing--;
            else
                maxRing++;

            res[i] = 1;
            if(maxRing == 0){
                i = mapping[i];
            }else{
                i++;
            }
        }

        return res;
    }
}