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
 class Pair{
    TreeNode node;
    int depth;
    public Pair(TreeNode node, int depth){
        this.node = node;
        this.depth = depth;
    }
}
class Solution {
    public Pair helper(TreeNode root, int depth){
        if(root == null)return new Pair(null,depth);

        Pair left = helper(root.left, depth + 1);
        Pair right = helper(root.right, depth + 1);

        if(left.depth == right.depth){
            return new Pair(root, left.depth);
        }else if(left.depth > right.depth){
            return left;
        }
        return right;
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return helper(root, 0).node;
    }
}
