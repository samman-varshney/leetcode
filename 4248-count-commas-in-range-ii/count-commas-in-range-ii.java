class Solution {

    public long countCommas(long n) {

        return
            1L * Math.max(0L, Math.min(n, 999_999L) - 999L)
          + 2L * Math.max(0L, Math.min(n, 999_999_999L) - 999_999L)
          + 3L * Math.max(0L, Math.min(n, 999_999_999_999L) - 999_999_999L)
          + 4L * Math.max(0L, Math.min(n, 999_999_999_999_999L) - 999_999_999_999L)
          + 5L * Math.max(0L, Math.min(n, 999_999_999_999_999_999L) - 999_999_999_999_999L);
    }
}