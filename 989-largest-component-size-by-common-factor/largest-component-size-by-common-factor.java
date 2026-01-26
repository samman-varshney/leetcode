class Solution {
    int[] parent, size;
    int find(int u){
        if(u == parent[u]){
            return u;
        }
        return parent[u] = find(parent[u]);
    }
    void union(int u, int v){
        int pu = find(u);
        int pv = find(v);
        if(pu == pv)return ;
        if(size[pu] > size[pv]){
            size[pu] += size[pv];
            parent[pv] = pu;
        }else {
            size[pv] += size[pu];
            parent[pu] = pv;
        }

    }
    void helper(HashMap<Integer, Integer> map, int j, int i, int[] nums){
        if(map.containsKey(j)){
            union(map.get(j), i);
        }else{
            map.put(j, i);
        }
    }
    public int largestComponentSize(int[] nums) {
        int n = nums.length;
        parent = new int[n];
        size = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
            size[i] = 1;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){
           
            int x = nums[i];
            for(int p = 2; p * p <= x; p++){
                if(x % p == 0){
                    helper(map, p, i, nums);
                    while(x % p == 0) x /= p;
                }
            }
            if(x > 1){
                helper(map, x, i, nums);
            }
        }

        
        int maxSize = 0;
        for(int i=0; i<n; i++){
            if(i == find(i)){
                maxSize = Math.max(maxSize, size[i]);
            }
        }
        return maxSize;
    }
}