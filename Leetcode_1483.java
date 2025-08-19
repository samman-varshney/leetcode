public class Leetcode_1483 {
    public static void main(String[] args) {
        
    }
}
class TreeAncestor {

    int MAX = 16;
    int[] parent;
    int n;
    int[][] table;

    private void build(){
        table = new int[16][n];
        for(int i=0; i<n; i++){
            table[0][i] = parent[i];
        }
        for(int i=1; i<MAX; i++){
            for(int j=0; j<n; j++){
                int parent = table[i-1][j];
                if(parent == -1){
                    table[i][j] = -1;
                    continue;
                }
                table[i][j] = table[i-1][parent];
            }
        }
    }
   
    public TreeAncestor(int n, int[] parent) {
        this.parent = parent;
        this.n = n;
        build();
    }
    
    public int getKthAncestor(int node, int k) {
   
        for(int i=0; i<MAX; i++){
            int ancestor = (1<<i);
            if((k&ancestor) != 0){
                node = table[i][node];
                if(node == -1)return -1;
            }
        }

        return node;
    }
}