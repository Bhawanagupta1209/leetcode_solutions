class Main {
    public static int frogJump(int[] heights) {
        int n = heights.length;
        int prev2 = 0, prev1 = 0;

        for (int i = 1; i < n; i++) {
            int fs = prev1 + Math.abs(heights[i] - heights[i - 1]);
            int ss = Integer.MAX_VALUE;
            if (i > 1) {
                ss = prev2 + Math.abs(heights[i] - heights[i - 2]);
            }
            int curri = Math.min(fs, ss);
            prev2 = prev1;
            prev1 = curri;
        }

        return prev1;
    }
}
