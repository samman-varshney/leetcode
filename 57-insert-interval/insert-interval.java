class Solution {
    public int[][] insert(int[][] intervals, int[] ntrl) {
      
        int max = Math.max(ntrl[0], ntrl[1]);
        for(int[] it: intervals){
            max = Math.max(max, Math.max(it[0], it[1]));
        }
        int[] map = new int[max+1];
        Arrays.fill(map, Integer.MIN_VALUE);

        for(int[] itrl: intervals){
            map[itrl[0]] = map[itrl[0]]==Integer.MIN_VALUE?1:map[itrl[0]]+1;
            map[itrl[1]] = map[itrl[1]]==Integer.MIN_VALUE?-1:map[itrl[1]]-1;
        }

        map[ntrl[0]] = map[ntrl[0]]==Integer.MIN_VALUE?1:map[ntrl[0]]+1;
        map[ntrl[1]] = map[ntrl[1]]==Integer.MIN_VALUE?-1:map[ntrl[1]]-1;

        int sum = 0;
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<map.length; i++){
            if(map[i] == Integer.MIN_VALUE)continue;
            
            if(sum == 0){
                list.add(new ArrayList<>());
                list.get(list.size()-1).add(i);
            }
            sum += map[i];
            if(sum == 0){
                list.get(list.size()-1).add(i);
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