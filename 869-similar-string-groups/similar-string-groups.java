class Solution {
    int[] parent, size;
    int find(int u){
        if(u == parent[u])
            return u;
        return parent[u] = find(parent[u]);
    }

    void union(int u, int v){
        int pu = find(u);
        int pv = find(v);
        if(pu == pv)return;
        if(size[pu] > size[pv]){
            size[pu] += size[pv];
            parent[pv] = pu;
        }else{
            size[pv] += size[pu];
            parent[pu] = pv;
        }
    }

    boolean isSimilar(String s1, String s2){
        int disimilar = 0;
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i))
                disimilar++;
            if(disimilar > 2){
                return false;
            }
        }
        return true;
    }
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        parent = new int[n];
        size = new int[n];

        for(int i=0; i<n; i++){
            parent[i] = i;
            size[i] = 1;
        }

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(isSimilar(strs[i], strs[j])){
                    union(i, j);
                }
            }
        }

        int groups = 0;
        for(int i=0; i<n; i++){
            if(i == find(i)){
                groups++;
            }
        }
        return groups;
    }
}