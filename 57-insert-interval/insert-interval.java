class Solution {
    public int[][] insert(int[][] intervals, int[] ntrl) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int[] itrl: intervals){
            map.put(itrl[0], map.getOrDefault(itrl[0], 0)+1);
            map.put(itrl[1], map.getOrDefault(itrl[1], 0)-1);
        }

        map.put(ntrl[0], map.getOrDefault(ntrl[0], 0)+1);
        map.put(ntrl[1], map.getOrDefault(ntrl[1], 0)-1);

        int sum = 0;
        List<List<Integer>> list = new ArrayList<>();
        for(int key : map.keySet()){
            if(sum == 0){
                list.add(new ArrayList<>());
                list.get(list.size()-1).add(key);
            }
            sum += map.get(key);
            if(sum == 0){
                list.get(list.size()-1).add(key);
            }
        }

        int[][] res = new int[list.size()][2];
        int i = 0;
        for(List<Integer> l: list){
            res[i][0] = l.get(0);
            res[i][1] = l.get(1);
            i++;
        }
        return res;
    }
}