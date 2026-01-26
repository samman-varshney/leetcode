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
    // Source - https://stackoverflow.com/a/19738969
// Posted by Jack, modified by community. See post 'Timeline' for change history
// Retrieved 2026-01-26, License - CC BY-SA 3.0

int gcd(int a, int b)
{
    int temp;
    while (b != 0)
    {
        temp = a % b;

        a = b;
        b = temp;
    }
    return a;
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
            for(int j=2; j*j<=nums[i]; j++){
                if(nums[i]%j == 0){
                    if(map.containsKey(j)){
                        union(map.get(j), i);
                    }else{
                        map.put(j, i);
                    }
                    if(map.containsKey(nums[i]/j)){
                        union(map.get(nums[i]/j), i);
                    }else{
                        map.put(nums[i]/j, i);
                    }
                }
            }
            if(map.containsKey(nums[i])){
                union(map.get(nums[i]), i);
            }else{
                map.put(nums[i], i);
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