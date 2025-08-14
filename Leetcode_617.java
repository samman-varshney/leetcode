public class Leetcode_617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)
            return null;
        if(root1 == null || root2 == null)
            return root1==null?root2:root1;
        
        TreeNode left = mergeTrees(root1.left, root2.left);
        TreeNode right = mergeTrees(root1.right, root2.right);

        TreeNode result = new TreeNode();
        result.left = left;
        result.right = right;
        result.val = root1.val + root2.val;
        
        return result;
    }
    public static void main(String[] args) {
        
    }
}
