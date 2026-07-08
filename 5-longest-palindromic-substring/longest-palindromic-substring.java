class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        char[] modified = new char[2 * n + 3];

        modified[0] = '^';
        modified[2 * n + 2] = '$';
        modified[2 * n + 1] = '#';

        int k = 0;
        for (int i = 1; i <= 2 * n; i += 2) {
            modified[i] = '#';
            modified[i + 1] = s.charAt(k++);
        }

        int[] p = new int[2 * n + 3];
        int l = 0, r = 1;
        int maxLen = 0;
        int idx = -1;
        for (int i = 1; i <= 2 * n + 1; i++) {

            if (i < r) {
                p[i] = Math.min(p[l + (r - i)], r - i - 1);
            }

            while ((i + p[i] + 1 < 2 * n + 3) &&
                    (i - p[i] - 1 >= 0) &&
                    (modified[i + p[i] + 1] == modified[i - p[i] - 1])) 
            {
                p[i]++;
            }

            if(maxLen < p[i]){
                maxLen = p[i];
                idx = ((i - p[i]) - 1)/2;
            }

            if (i + p[i] > r) {
                l = i - p[i] - 1;
                r = i + p[i] + 1;
            }
        }
        return s.substring(idx, idx + maxLen);
    }
}