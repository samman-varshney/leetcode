class TrieNode{
    TrieNode[] child;
    int count;

    public TrieNode(){
        child = new TrieNode[2];
        count = 0;
    }
}

class Trie{
    TrieNode root;
    public Trie(){
        root = new TrieNode();
    }

    public void insert(int num){
        TrieNode node = root;
        for(int i=31; i>=0; i--){
            int bit = ((num>>i)&1);
            if(node.child[bit] == null){
                node.child[bit] = new TrieNode();
            }
            node = node.child[bit];
            node.count++;
        }
    }

    public void delete(int num){
        TrieNode node = root;
        for(int i=31; i>=0; i--){
            int bit = ((num>>i)&1);
            node.child[bit].count--;
            if(node.child[bit].count <= 0){
                node.child[bit] = null;
                break;
            }
            node = node.child[bit];
        }
    }

    public int getMaxXor(int num){
        TrieNode node = root;
        int res = 0;
        for(int i=31; i>=0; i--){
            int bit = ((num>>i)&1);
            int opposite = bit^1;
            if(node.child[opposite] != null){
                res |= (1<<i);
                node = node.child[opposite];
            }else{
                node = node.child[bit];
            }
        }
        return res;
    }

}
class Solution {
    public int upperBound(int[] nums, int val){
        int n = nums.length;
        int start  = 0, end = n-1;
        while(start <= end){
            int mid = (end - start)/2 + start;
            if(nums[mid] >= val){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return start;
    }
    public int maximumStrongPairXor(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        Trie t = new Trie();
        int i = 0;
        int res = 0;
        for(int j=0; j<n; j++){

            //remove num less the half of current element
            int half = (nums[j]+1)/2;
            int idx = upperBound(nums, half);
            for(int k=i; k<idx; k++){
                t.delete(nums[k]);
            }
            i = idx;

            //insert current element
            t.insert(nums[j]);

            //check maximum xor for current element
            res = Math.max(res, t.getMaxXor(nums[j]));
        }

        return res;
    }
}