class Solution {
    boolean possible(int pos, TreeSet<Integer> set){
        if (set.contains(pos)) return false;

        Integer nxt = set.higher(pos);
        if (nxt == null) return true;

        return nxt - pos >= 4;
    }
    public int maxNumberOfFamilies(int n, int[][] rsvd) {
        int m = rsvd.length;
        HashMap<Integer, TreeSet<Integer>> map = new HashMap<>();
        for(int[] x : rsvd){
            map.computeIfAbsent(x[0], k->new TreeSet<>()).add(x[1]);
        }
        int res = (n - map.size())*2;
        for(TreeSet<Integer> set: map.values()){
            boolean pos2 = possible(2, set);
            boolean pos4 = possible(4, set);
            boolean pos6 = possible(6, set);

            if(pos2 && pos6)res+=2;
            else if(pos2 || pos4 || pos6)res+=1;
        }
        return res;
    }
}