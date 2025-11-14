class Solution {
    public int maxOperations(String str) {
        int n = str.length();
        char[] s = str.toCharArray();
        int prev = n;
        int res = 0;
        int last = 0;
        for(int i=n-1; i>=0; i--){
            if(s[i] == '1'){
                int diff = prev - i;
                if(diff > 1){
                    res += 1 + last;
                    last += 1;
                }else{
                    res+= last;
                }
                prev = i;
            }
        }
        return res;
    }
} 