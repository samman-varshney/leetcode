class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        HashMap<Integer, TreeSet<Integer>> xAxis = new HashMap<>();
        HashMap<Integer, TreeSet<Integer>> yAxis = new HashMap<>();


        for(int[] point: buildings){
            xAxis.computeIfAbsent(point[0], k->new TreeSet()).add(point[1]);
            yAxis.computeIfAbsent(point[1], k->new TreeSet()).add(point[0]);
        }

        int count = 0;
        for(int[] point: buildings){
            TreeSet<Integer> horizontal = xAxis.get(point[0]);
            if(horizontal.ceiling(point[1]+1)==null || horizontal.floor(point[1]-1)==null)
                continue;
            TreeSet<Integer> vertical  = yAxis.get(point[1]);
            if(vertical.ceiling(point[0]+1)==null || vertical.floor(point[0]-1)==null)
                continue;
            count++;
        }
        return count;
    }
}