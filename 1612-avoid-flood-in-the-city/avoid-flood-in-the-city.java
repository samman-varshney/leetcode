class Solution {
    int[] parent;
    int[] nums;
    public int find(int u){
        if(nums[u] == 0 || parent[u] == u){
            return u;
        }
        return parent[u] = find(parent[u]);
    }
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        parent = new int[n];
        nums = new int[n];
    
        for(int i=0; i<n; i++){
            parent[i] = i;
            nums[i] = rains[i];
        }

        int[] result = new int[n];
        Arrays.fill(result, -1);
        HashMap<Integer, Integer> map = new HashMap<>();

        int lastZero = -1;
        int prev = -1;
        for(int i=0; i<n; i++){
            if(rains[i] == 0){
                if(lastZero!=-1)parent[lastZero] = i;
                if(prev!=-1 && nums[find(prev)]!=0)parent[prev] = i;
                lastZero = i;
            }else{
                int lastOccur = map.getOrDefault(rains[i], -1);
                if(lastOccur != -1){
                    int pi = find(lastOccur);
                    if(nums[pi] != 0){
                        return new int[]{};
                    }
                    nums[pi] = -1;
                    result[pi] = rains[i];
                }
                map.put(rains[i], i);
                if(prev!=-1 && nums[find(prev)]!=0)parent[prev] = i;
                prev = i;
            }
        }

        for(int i=0; i<n; i++){
            if(rains[i] == 0 && result[i] == -1){
                result[i] = 1;
            }
        }
        return result;
    }
}