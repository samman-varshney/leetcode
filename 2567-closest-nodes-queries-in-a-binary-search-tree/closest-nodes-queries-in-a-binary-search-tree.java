class Solution {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> list = new ArrayList<>();
        inorder(list, root);
        List<List<Integer>> res = new ArrayList<>();
        for (int q : queries){
            res.add(binarySearch(list, q));
        }
        return res;
    }
    private List<Integer> binarySearch(List<Integer> list, int n){
        int low = 0;
        int high = list.size() - 1;
        int min = -1;
        int max = -1;
        while (low <= high){
            int mid = low + (high - low) / 2;
            int temp = list.get(mid);
            if (temp == n){
                min = temp;
                max = temp;
                break;
            }else if (temp < n){
                min = temp;
                low = mid + 1;
            }else{
                max = temp;
                high = mid - 1;
            }
        }
        List<Integer> res = new ArrayList<>();
        res.add(min);
        res.add(max);
        return res;
    }
    private void inorder(List<Integer> res, TreeNode root){
        if (root == null) return;
        inorder(res, root.left);
        res.add(root.val);
        inorder(res, root.right);
    }
}
