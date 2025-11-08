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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int idx = 0;
        HashMap<String, Integer> indices = new HashMap<>();
        for(List<String> acnt: accounts){
            for(int i=1; i<acnt.size(); i++){
                if(!indices.containsKey(acnt.get(i))){
                    indices.put(acnt.get(i), idx++);
                }
            }
        }
        parent = new int[idx];
        size = new int[idx];

        for(int i=0; i<idx; i++){
            parent[i] = i;
            size[i] = 1;
        }

        for(List<String> act : accounts){
            for(int i=1; i<act.size()-1; i++){
                union(indices.get(act.get(i)), indices.get(act.get(i+1)));
            }
        }
        int[] merged = new int[accounts.size()];

        List<List<String>> res = new ArrayList<>();
        for(int i=0; i<accounts.size(); i++){
            if(merged[i] == 1)continue;
            TreeSet<String> set = new TreeSet<>();
            int mail = indices.get(accounts.get(i).get(1));

            for(int j=i; j<accounts.size(); j++){
                if(merged[j]==0 && find(mail) == find(indices.get(accounts.get(j).get(1)))){
                    merged[j] = 1;
                    for(int k=1; k<accounts.get(j).size(); k++){
                        set.add(accounts.get(j).get(k));
                    }

                }
            }

            List<String> list = new ArrayList<>();
            list.add(accounts.get(i).get(0));
            for(String s: set){
                list.add(s);
            }
            res.add(list);
        }
        return res;
    }
}