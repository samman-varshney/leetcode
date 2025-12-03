class Solution {
    public int countTrapezoids(int[][] points) {
        int mod = 1000000007;
        HashMap<Integer, Long> map = new HashMap<>();

        for (int[] point : points) {
            map.put(point[1], map.getOrDefault(point[1], 0L) + 1L); 
        }

        List<Long> l = new ArrayList<>(map.values());
        long[] prefix = new long[l.size() + 1];

        for (int i = l.size() - 1; i >= 0; i--) {
            long point = l.get(i);
            prefix[i] = (prefix[i + 1] + (point * (point - 1)) / 2) % mod;
        }

        long res = 0;
        for (int i = 0; i < l.size(); i++) {
            long point = l.get(i);
            res = (res + ((point * (point - 1) / 2) * prefix[i + 1])%mod) % mod;
        }
        return (int) res;
    }
}
