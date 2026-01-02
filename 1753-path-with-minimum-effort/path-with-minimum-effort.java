class Triplet{
    int x, y, effort;
    Triplet(int x, int y, int effort){
        this.x = x;
        this.y = y;
        this.effort = effort;
    }
}
class Solution {
    public int minimumEffortPath(int[][] hts) {
        int n = hts.length, m = hts[0].length;
        int[][] efforts = new int[n][m];
        for(int[] x: efforts){
            Arrays.fill(x, Integer.MAX_VALUE);
        }
        efforts[0][0] = 0;
        PriorityQueue<Triplet> pq = new PriorityQueue<>((a, b)->(a.effort - b.effort));

        int[][] D = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        pq.add(new Triplet(0, 0, 0));
        while(!pq.isEmpty()){
            Triplet t = pq.poll();
            
            if(efforts[t.x][t.y] < t.effort)continue;

            if(t.x == n-1 && t.y == m-1){
                return t.effort;
            }

            for(int[] d: D){
                int x = t.x+d[0];
                int y = t.y+d[1];

                if(x<n && x>=0 && y>=0 && y<m){
                    int effort = Math.max(t.effort, Math.abs(hts[t.x][t.y] - hts[x][y]));
                    if(efforts[x][y] > effort){
                        efforts[x][y] = effort;
                        pq.add(new Triplet(x, y, effort));
                    }
                }
            }
        }
        return -1;
    }
}