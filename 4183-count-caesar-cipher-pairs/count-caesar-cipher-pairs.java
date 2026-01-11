class Solution {
    public long countPairs(String[] words) {
        int n = words.length;
        int m = words[0].length();
        long count = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(words[i], map.getOrDefault(words[i], 0)+1);
        }

        for(int i=0; i<n; i++){
            map.put(words[i], map.get(words[i])-1);
            if(map.get(words[i]) == 0){
                map.remove(words[i]);
            }
            
            for(int j=0; j<26; j++){
                StringBuilder s = new StringBuilder();
                for(int k=0; k<m; k++){
                    char c = words[i].charAt(k);
                    char shifted = (char)('a' + (c - 'a' + j) % 26);
                    s.append(shifted);
                }
                count += map.getOrDefault(s.toString(), 0);
            }
        }
        return count;
    }
}