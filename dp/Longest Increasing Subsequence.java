class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return f(nums,-1,0,dp);
    }
    public int f(int[] nums,int prevIndex,int currIndex,int[][] dp){
        if(currIndex == nums.length) return 0;
        if(dp[currIndex][prevIndex+1]!=-1) return dp[currIndex][prevIndex+1];
        int excluded = f(nums,prevIndex,currIndex+1,dp);
        int included = 0;
        if(prevIndex == -1 || nums[currIndex]>nums[prevIndex]){
            included = 1+f(nums,currIndex,currIndex+1,dp);
        }
        return dp[currIndex][prevIndex+1] = Math.max(excluded,included);
    }
}
