import java.util.ArrayList;
import java.util.List;

public class Leetcode_113 {
     public boolean isLeaf(TreeNode root){
        return root.right == null && root.left == null;
    }
    public void helper(TreeNode root, int tarSum, List<List<Integer>> res, List<Integer> local){
        
        if(root == null )return;
        local.add(root.val);

        if(root.val == tarSum && isLeaf(root)){
            res.add(new ArrayList<>(local));
            local.remove(local.size()-1);
            return;
        }

        
        helper(root.left, tarSum-root.val, res, local);
        helper(root.right, tarSum-root.val, res, local);
        local.remove(local.size()-1);

    }
    public List<List<Integer>> pathSum(TreeNode root, int tarSum) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, tarSum, res, new ArrayList<>());
        return res;
    }
    public static void main(String[] args) {
        
    }
}
