class DLL{
    long val;
    DLL next, prev;
    int idx;
    public DLL(long val, int idx){
        this.val = val;
        this.idx = idx;
        this.next = null;
        this.prev = null;
    }
}
class Item{
    DLL node;
    long cost;
    public Item(DLL node, long cost){
        this.cost = cost;
        this.node = node;
    }
}
class Solution {

    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        
        TreeSet<Item> set = new TreeSet<>((a, b) -> {
            if (a.cost != b.cost) return Long.compare(a.cost, b.cost);
            return Integer.compare(a.node.idx, b.node.idx);
        });

        DLL head = new DLL(nums[0], 0);
        DLL dummy = head;
        int decreaseCount = 0;

        for(int i=1; i<nums.length; i++){
            DLL temp = new DLL(nums[i], i);
            dummy.next = temp;
            temp.prev = dummy;
            set.add(new Item(dummy, dummy.val+temp.val));
            dummy = temp;
            if(nums[i-1] > nums[i]){
                decreaseCount++;
            }
        }

        int steps = 0;
        boolean[] merged = new boolean[n];

        while(decreaseCount > 0){

            Item t = set.pollFirst();
            DLL node = t.node;
            long cost = t.cost;
            DLL second = node.next;
            
            if(
                merged[node.idx] || second == null || 
                merged[second.idx] || (node.val + second.val) != cost
            ) {
                continue;
            }

            if(node.val > second.val){
                decreaseCount--;
            }

            steps++;

            merged[second.idx] = true;
           
            DLL prevNode = node.prev;
            if(prevNode != null){
                if(prevNode.val > node.val && prevNode.val <= cost)
                    decreaseCount--;
                else if(prevNode.val <= node.val && prevNode.val > cost)
                    decreaseCount++;
                set.add(new Item(prevNode, prevNode.val + cost));
            }
            
            
            DLL nextNode = node.next.next;
            node.next = nextNode;
            
            if(nextNode != null){
                nextNode.prev = node;
                if(second.val <= nextNode.val && nextNode.val < cost)
                    decreaseCount++;
                else if(second.val > nextNode.val && nextNode.val >= cost)
                    decreaseCount--;
                set.add(new Item(node, cost + nextNode.val));
            }  

            node.val = cost; 
        }
        return steps;
    }
}