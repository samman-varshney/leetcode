class Solution {
    public long calculateScore(String s) {
        int n = s.length();
        int[] map = new int[26];
        int[] trace = new int[n];
        Arrays.fill(map, -1);

        long res = 0;
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            char mirror = (char)('z'-c+'a');
            // System.out.println(mirror);
            if(map[mirror-'a'] != -1){
                int j = map[mirror-'a'];
                res += i -j;
                if(trace[j] != j){
                    map[mirror-'a'] = trace[j];
                }else{
                    map[mirror-'a'] = -1;
                }
            }else { 
                if(map[c-'a']!=-1){
                    trace[i] = map[c-'a'];
                }else{
                    trace[i] = i;
                }
                map[c-'a'] = i;
            }
        }
        return res;
    }
}