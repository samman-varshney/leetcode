class Solution {
    public int edgeScore(int[] edges) {
        int n_length=edges.length;
		//to avoid overflow we will take long size score array 
        long score_of_node[]=new long[n_length];
        for(int i=0; i<n_length; i++){
            score_of_node[edges[i]]+=i; //score of the node will be update to (prev score + incomming node) here every i denotes income incomming vertex
        }
        int max_ans_index=0;
        
        for(int i=0; i<n_length; i++){
            if(score_of_node[i]>score_of_node[max_ans_index]){
                max_ans_index=i; // simply just find the node with maximum score and
            }
        }
        return max_ans_index; // return the node
    }
}