class Solution {
    int[] parent, size;
    void union(int u, int v){
        int pu = find(u);
        int pv = find(v);

        if(pu == pv)return;
        else if(size[pu] > size[pv]){
            size[pu] += size[pv];
            parent[pv] = pu;
        }else{
            size[pv] += size[pu];
            parent[pu] = pv;
        }
    }
    int find(int u){
        if(u == parent[u]){
            return u;
        }
        return parent[u] = find(parent[u]);
    }
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        parent = new int[n];
        size = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            parent[i] = i;
            size[i] = 1;
            map.put(nums[i], i);
        } 

        for(int key : map.keySet()){
            if(map.containsKey(key-1)){
                union(map.get(key), map.get(key-1));
            }
        }
        int res = 0;
        for(int i=0; i<n; i++){
            res = Math.max(res, size[i]); 
        }
        return res;
    }
}