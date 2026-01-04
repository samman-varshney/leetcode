class Solution {
    public int maxRepeating(String sequence, String word) {
        int i = 0;
        String pattern = word;
        while(pattern.length() <= sequence.length() && sequence.indexOf(pattern)!=-1){
            i++;
            pattern = pattern+word;
        }
        return i;
    }
}