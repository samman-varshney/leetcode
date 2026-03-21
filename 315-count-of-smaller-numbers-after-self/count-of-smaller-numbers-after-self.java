class Solution {
    int[] nums, indices;
    List<Integer> res;
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        this.nums = nums;
        this.indices = new int[n];
        this.res = new ArrayList<>(n);

        for(int i=0; i<n; i++){
            indices[i] = i;  
            res.add(0);
        }
        
        sort(0, n-1);
        return res;
    }

    void sort(int l, int r){
        if(l < r){
            int mid = (l + r)/2;
            sort(l, mid);
            sort(mid+1, r);
            merge(l, r);
        }
    }

    void merge(int l, int r){
        int mid = (l + r)/2;
        int[] sorted = new int[r - l + 1];
        int i=l, j=mid+1, k=0;
        while(i<=mid && j<=r){
            if(nums[indices[i]] > nums[indices[j]]){
                sorted[k++] = indices[j++];
            }else{
                res.set(indices[i], res.get(indices[i])+(j - mid - 1));
                sorted[k++] = indices[i++];
            }
        }

        while(i<=mid){
            res.set(indices[i], res.get(indices[i])+(j - mid - 1));
            sorted[k++] = indices[i++];
        }

        while(j<=r){
            sorted[k++] = indices[j++];
        }

        for(k =l; k<=r; k++){
            indices[k] = sorted[k-l];
        }
    }
}