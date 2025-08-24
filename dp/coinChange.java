class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans = f(n-1,amount,coins,dp);
        if(ans == Integer.MAX_VALUE){
            return -1;
        } else{
            return ans;
        }
        
    }
    public int f(int index , int amount,int[] coins,int[][] dp){
        if(index<0) return Integer.MAX_VALUE;
        if(amount==0) return 0;
        if(dp[index][amount]!=-1) return dp[index][amount];
        int notTake = f(index-1,amount,coins,dp);
        int take = Integer.MAX_VALUE;
        if(coins[index]<=amount){
            int res = f(index,amount-coins[index],coins,dp); //Infinite supply
            if(res != Integer.MAX_VALUE){
                take = 1+res;
            }      
        }
        return dp[index][amount] = Math.min(notTake,take);
    }
}
