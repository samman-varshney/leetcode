class Solution {
    public boolean canMakeSubsequence(String str, String tr) {
        if(str.length() > tr.length())return false;

        char[] s = str.toCharArray();
        char[] t = tr.toCharArray();

        int n = s.length;
        int m = t.length;

        int[] left = new int[n];
        int[] right = new int[n];

        int j = 0;
        for(int i=0; i<n; i++){
            while(j<m && t[j] != s[i])j++;
            left[i] = j++;
        }

        j = m-1;
        for(int i=n-1; i>=0; i--){
            while(j>=0 && t[j] != s[i])j--;
            right[i] = j--;
        }
        // System.out.println(Arrays.toString(left));
        // System.out.println(Arrays.toString(right));
        for(int i=0; i<n; i++){
            int l = i==0?-1:left[i-1];
            int r = i==n-1?m: right[i+1];

            if(l + 1 < r)return true;
        }

        return false;

    }
}