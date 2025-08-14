public class Leetcode_270 {
    public int kthSmallest(TreeNode root, int k) {
        
        TreeNode curr = root;
        while(curr != null){
            if(curr.left  == null){
                k--;
                if( k == 0){
                    return curr.val;
                }
                curr = curr.right;
            }else{
                TreeNode left = curr.left;
                
                while(left.right != curr && left.right != null){
                    left = left.right;
                }

                if(left.right == curr){
                    left.right = null;
                    k--;
                    if(k == 0){
                        return curr.val;
                    }
                    curr = curr.right;
                }else{
                    left.right = curr;
                    curr = curr.left;
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        
    }
}
