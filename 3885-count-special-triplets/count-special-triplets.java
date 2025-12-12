class Solution {
    public int specialTriplets(int[] nums) {
        int n = nums.length;
        int mod = (int) 1e9 + 7;

        HashMap<Integer, Integer> map = new HashMap<>(n * 2);
        int[] left = new int[n];

        // Left count
        for (int i = 0; i < n; i++) {
            int doubled = nums[i] << 1;
            left[i] = map.getOrDefault(doubled, 0);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // Right count
        map.clear();
        long res = 0;

        for (int i = n - 1; i >= 0; i--) {
            int doubled = nums[i] << 1;
            int right = map.getOrDefault(doubled, 0);

            res += (long) left[i] * right;
            if (res >= mod) res %= mod;

            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        return (int) res;
    }
}
