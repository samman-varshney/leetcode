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
    public long sumOfTree(TreeNode root){
        if(root == null){
            return 0;
        }

        long left = sumOfTree(root.left);
        long right = sumOfTree(root.right);

        return left + right + root.val;
    }
    long product;
    long sum ;
    public long maxProductOfSubtree(TreeNode root){
        if(root == null){
            return 0;
        }

        long left = maxProductOfSubtree(root.left);
        long right = maxProductOfSubtree(root.right);
        
        long part1 = left + right + root.val;
        long part2 = sum - part1;

        product = Math.max(product, part1 * part2);
        return part1;
    }
    public int maxProduct(TreeNode root) {
        sum  = sumOfTree(root);
        product = Long.MIN_VALUE;
        maxProductOfSubtree(root);

        return (int)(product%((int)(1e9+7)));
    }
}