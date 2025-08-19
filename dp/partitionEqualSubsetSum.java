class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
        }

        if (totalSum % 2 != 0) return false;

        int target = totalSum / 2;
        boolean[][] dp = new boolean[n][target + 1];

        // Base case: sum 0 is always possible
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int s = 1; s <= target; s++) {
                boolean notTake = dp[i - 1][s];
                boolean take = false;
                if (nums[i] <= s) {
                    take = dp[i - 1][s - nums[i]];
                }
                dp[i][s] = take || notTake;
            }
        }

        return dp[n - 1][target];
    }
}

