/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
     
        List<Integer> order = new ArrayList<>();
        if(root == null)return order;

        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode node = st.pop();
            order.add(node.val);
            
            if(node.left!=null){
                st.push(node.left);
            }

            if(node.right!=null){
                st.push(node.right);
            }
        }

        int i=0, j=order.size()-1;
        while(i<j){
            int tmp = order.get(i);
            order.set(i, order.get(j));
            order.set(j, tmp);
            i++;j--;
        }

        return order;
    }
}