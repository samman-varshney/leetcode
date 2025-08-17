public class Leetcode_988 {
    
    public StringBuilder smallest(StringBuilder s1, StringBuilder s2){
        for(int i=0; i<Math.min(s1.length(), s2.length()); i++){
            if(s1.charAt(i) > s2.charAt(i))
                return s2; // return copy
            else if(s1.charAt(i) < s2.charAt(i))
                return s1; // return copy
        }
        return s1.length() < s2.length()? s1: s2;
    }

    public StringBuilder helper(TreeNode root, StringBuilder str){
        str.append((char)(root.val + 'a'));

        if(root.left == null && root.right == null){
            StringBuilder res = new StringBuilder(str); 
            res.reverse();  // reverse a copy, not str itself
            str.deleteCharAt(str.length()-1);
            return res;
        }

        StringBuilder res;
        if(root.left == null){
            res = helper(root.right, str);
        } else if(root.right == null){
            res = helper(root.left, str);
        } else {
            StringBuilder left = helper(root.left, str);
            StringBuilder right = helper(root.right, str);
            res = smallest(left, right);
        }

        str.deleteCharAt(str.length()-1);
        return res;
    }

    public String smallestFromLeaf(TreeNode root) {
       return helper(root, new StringBuilder()).toString();
    }
}
