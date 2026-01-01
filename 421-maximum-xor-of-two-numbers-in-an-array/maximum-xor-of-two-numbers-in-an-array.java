class TrieNode{
    TrieNode[] child;
    public TrieNode(){
        child = new TrieNode[2];
    }
}

class Trie{
    TrieNode root;
    public Trie(){
        root = new TrieNode();
    }

    void insert(int num){
        TrieNode node = root;
        for(int i=31; i>=0; i--){
            int bit = ((num>>i)&1);
            if(node.child[bit] == null){
                node.child[bit] = new TrieNode();
            }
            node = node.child[bit];
        }
    }

    int getMaxXor(int num){
        int res = 0;
        TrieNode node = root;
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
    public int findMaximumXOR(int[] nums) {
        Trie t = new Trie();
        for(int x: nums){
            t.insert(x);
        }

        int max = Integer.MIN_VALUE;
        for(int x: nums){
            max = Math.max(max, t.getMaxXor(x));
        }
        return max;
    }
}