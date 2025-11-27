class Solution {
    public int maxNumberOfFamilies(int n, int[][] rsvd) {
        int m = rsvd.length;
        if (m == 0) return n * 2;

        Arrays.sort(rsvd, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        int res = 0;

        int prev = 1;
        int next = rsvd[0][0];

        res += (next - prev) * 2;
        prev = next;

        int i = 0;
        while (i < m) {

            int j = i;
            int[] row = new int[10];
            while (j < m && rsvd[i][0] == rsvd[j][0]) {
                row[rsvd[j][1] - 1] = -1;
                j++;
            }

            // prefix array
            int[] prefix = new int[11];
            for (int k = 9; k >= 0; k--) {
                if (row[k] == -1)
                    prefix[k] = 0;
                else
                    prefix[k] = prefix[k + 1] + 1;
            }

            if (prefix[1] >= 4 && prefix[5] >= 4) {
                res += 2;
            } else if (prefix[1] >= 4 || prefix[5] >= 4 || prefix[3] >= 4) {
                res += 1;
            }

            
            next = (j < m) ? rsvd[j][0] : n + 1;
            res += (next - prev - 1) * 2;
            prev = next;
            i = j;
        }

        return res;
    }
}
