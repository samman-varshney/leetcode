class Solution {
    public int prefix(String s, int pat){
        int n = s.length();
        int[] res = new int[n];
        for(int i=1; i<n; i++){
            int j = res[i-1];
            while(j>0 && s.charAt(i) != s.charAt(j)){
                j = res[j-1];
            }
            if(s.charAt(i) == s.charAt(j)){
                j++;
            }
            res[i] = j;
            if(pat == res[i]){
                return i-2*pat;
            }
        }
        return -1;
    }
    public int strStr(String haystack, String needle) {
        int n = needle.length(), m = haystack.length();
        String com = needle+"#"+haystack;
        return prefix(com, n);
    }
}