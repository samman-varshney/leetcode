class Solution {

    private int[] prepareCuts(int[] cutPoints, int limit) {
        Arrays.sort(cutPoints);
        int[] fullCuts = new int[cutPoints.length + 2];
        fullCuts[0] = 1;
        System.arraycopy(cutPoints, 0, fullCuts, 1, cutPoints.length);
        fullCuts[fullCuts.length - 1] = limit;
        return fullCuts;
    }

    public int maximizeSquareArea(int totalHeight, int totalWidth, int[] horizontalCuts, int[] verticalCuts) {
        long MOD = 1_000_000_007L;

        int[] h = prepareCuts(horizontalCuts, totalHeight);
        int[] v = prepareCuts(verticalCuts, totalWidth);

        HashSet<Integer> horizontalGapSet = new HashSet<>();

        for (int i = 0; i < h.length; i++) {
            for (int j = i + 1; j < h.length; j++) {
                horizontalGapSet.add(h[j] - h[i]);
            }
        }

        long bestGap = 0;

        for (int i = 0; i < v.length; i++) {
            for (int j = i + 1; j < v.length; j++) {
                int gapSize = v[j] - v[i];
                if (gapSize > bestGap && horizontalGapSet.contains(gapSize)) {
                    bestGap = gapSize;
                }
            }
        }

        return bestGap == 0 ? -1 : (int)((bestGap * bestGap) % MOD);
    }
}