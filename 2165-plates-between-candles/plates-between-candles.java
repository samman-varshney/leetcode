class Solution {
    public int[] platesBetweenCandles(String str, int[][] queries) {
        int n = str.length();
        char[] s = str.toCharArray();

        int[] prefix = new int[n+1];
        int[] sufix = new int[n+1];

        int open = -1;
        for(int i=1; i<=n; i++){
            if(s[i-1] == '|'){
                if(open != -1){
                    prefix[i] = prefix[i-1]+(i - open - 1);
                }
                open = i;
            }else{
                prefix[i] = prefix[i-1];
            }
        }
        open = -1;
        for(int i=1; i<=n; i++){
            sufix[i] = sufix[i-1];
            if(s[i-1] == '|'){
                if(open != -1){
                    for(int j=open; j<=i; j++){
                        sufix[j] += (i - open - 1);
                    }
                }
                open = i;
            }
        }

        // System.out.println(Arrays.toString(prefix));
        // System.out.println(Arrays.toString(sufix));

        int m = queries.length;
        int[] res = new int[m];
        for(int i=0; i<m; i++){
            res[i] = Math.max(prefix[queries[i][1]+1] - sufix[queries[i][0]], 0);
        }
        return res;
    }
}