import java.util.*;

class Solution {
    int[] parent, size;

    // Find with path compression
    int find(int u) {
        if (u == parent[u]) return u;
        return parent[u] = find(parent[u]);
    }

    // Union by size
    void union(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        if (pu == pv) return;
        if (size[pu] < size[pv]) {
            int temp = pu;
            pu = pv;
            pv = temp;
        }
        parent[pv] = pu;
        size[pu] += size[pv];
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        // Remove duplicates
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int n = set.size();
        parent = new int[n];
        size = new int[n];

        // Map number -> index
        Map<Integer, Integer> map = new HashMap<>();
        int idx = 0;
        for (int num : set) {
            parent[idx] = idx;
            size[idx] = 1;
            map.put(num, idx++);
        }

        // Union consecutive numbers
        for (int num : set) {
            if (map.containsKey(num + 1)) {
                union(map.get(num), map.get(num + 1));
            }
        }

        // Find largest set size
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (i == parent[i]) { // only check roots
                max = Math.max(max, size[i]);
            }
        }

        return max;
    }
}
