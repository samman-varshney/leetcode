class Solution {
    
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] visited = new int[n];
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);

        int node = node1, dist = 0;
        while(node != -1 && visited[node] == 0){
            dist1[node] = dist;
            visited[node] = 1;
            node = edges[node];
            dist++;
        }

        Arrays.fill(visited, 0);
        node = node2; dist = 0;
        while(node != -1 && visited[node] == 0){
            dist2[node] = dist;
            visited[node] = 1;
            node = edges[node];
            dist++;
        }
        dist = Integer.MAX_VALUE;
        int result = -1;
        for(int i=0; i<n; i++){
            if(dist1[i] != Integer.MAX_VALUE && dist2[i] != Integer.MAX_VALUE && dist > Math.max(dist1[i], dist2[i])){
                dist = Math.max(dist1[i], dist2[i]);
                result = i;
            }
        }
        return result;
    }
}