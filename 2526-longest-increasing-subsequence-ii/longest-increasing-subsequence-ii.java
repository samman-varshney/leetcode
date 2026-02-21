class Solution {
    int tree[];
    public int lengthOfLIS(int[] nums, int k) {
        int n = nums.length;
        int maxElement = Integer.MIN_VALUE;
        for(int x: nums){
            maxElement = Math.max(maxElement, x);
        }

        tree = new int[4*(maxElement+1)];

        int maxLen = Integer.MIN_VALUE;
        for(int x: nums){
            int len = 1;
            if(x != 1){
                len = query(0, 0, maxElement, Math.max(x-k, 1), x-1)+1;
            }
            update(0, 0, maxElement, x, len);
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
    public void update(int idx, int low, int high, int pos, int val){
        if(low == high){
            tree[idx] = val;
            return;
        }
        
        int mid = (low + high)/2;

        if(pos <= mid){
            update(2*idx + 1, low, mid, pos, val);
        }else{
            update(2*idx + 2, mid + 1, high, pos, val);
        }

        tree[idx] = Math.max(tree[2*idx+1], tree[2*idx+2]);
    }

    public int query(int idx, int low, int high, int l, int r){
        if(r < low || l > high){
            return 0;
        }

        if(l <= low && high <= r){
            return tree[idx];
        }

        int mid = (low + high)/2;

        int left = query(2*idx+1, low, mid, l, r);
        int right = query(2*idx+2, mid+1, high, l, r);

        return Math.max(left, right);
    }
}