public class Leetcode_1123 {
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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return helper(root, 0).node;
    }
}

class Pair{
    TreeNode node;
    int depth;
    public Pair(TreeNode node, int depth){
        this.node = node;
        this.depth = depth;
    }
}