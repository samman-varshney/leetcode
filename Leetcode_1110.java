import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Leetcode_1110 {
        public boolean helper(List<TreeNode> res, TreeNode root, HashSet<Integer> delete) {
        if (root == null) return false;

        boolean left = helper(res, root.left, delete);
        boolean right = helper(res, root.right, delete);

        if (left) root.left = null;
        if (right) root.right = null;

        if (delete.contains(root.val)) {
            if (root.left != null) res.add(root.left);
            if (root.right != null) res.add(root.right);
            return true;
        }
        return false;
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<Integer> delete = new HashSet<>();
        for (int val : to_delete) {
            delete.add(val);
        }

        List<TreeNode> res = new ArrayList<>();
        boolean result = helper(res, root, delete);

        if (!result) {
            res.add(root);
        }
        return res;
    }
}
