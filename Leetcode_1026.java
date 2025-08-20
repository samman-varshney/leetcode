public class Leetcode_1026 {
    int res;
    public int[] helper(TreeNode root, TreeNode parent){
        if(root == null)return new int[]{parent.val, parent.val};

        int[] left = helper(root.left, root);
        int[] right = helper(root.right, root);

        int min = Math.min(left[0], right[0]);
        int max = Math.max(left[1], right[1]);

        int currMax = Math.max(Math.abs(root.val-min), Math.abs(root.val - max));
        res = Math.max(res, currMax);

        return new int[]{Math.min(root.val, min), Math.max(root.val, max)};

    }
    public int maxAncestorDiff(TreeNode root) {
        res = 0;
        helper(root, new TreeNode(-1));
        return res;
    }
}
