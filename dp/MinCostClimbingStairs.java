class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if(cost == null || cost.length == 0) {
            return 0;
        }
        int first = cost[0];
        int second = cost[1];
        for(int i = 2; i < cost.length; i++) {
            int curr = cost[i] + Math.min(first, second);
            first = second;
            second = curr;
        }
        return Math.min(first, second);
    }
}
