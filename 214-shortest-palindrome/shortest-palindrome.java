class Solution {
    public String shortestPalindrome(String s) {
        char[] merge = (s+" "+new StringBuilder(s).reverse()).toCharArray();
        int[] p = new int[merge.length];
        
        
        for(int i=1; i<p.length; i++){
            int j = p[i-1];
            
            while(j > 0 && merge[i] != merge[j])
                j = p[j-1];
            
            if(merge[j] == merge[i])
                j++;
            
            p[i] = j;
        }

        return new StringBuilder(s.substring(p[p.length-1])).reverse() + s;
    }
}