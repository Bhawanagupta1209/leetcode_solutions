class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2*k+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return f(0,prices,0,k,dp);
    }
    public int f(int index,int[] prices,int count,int k,int[][] dp){
        if(index==prices.length) return 0;
        if(count == 2*k) return 0;
        if(dp[index][count]!=-1) return dp[index][count];
        int profit;
        if(count%2==0){
            int canbuy = -prices[index]+f(index+1,prices,count+1,k,dp);
            int notBuy = f(index+1,prices,count,k,dp);
            profit = Math.max(canbuy,notBuy);
        } else{
            int sell = prices[index]+f(index+1,prices,count+1,k,dp);
            int notSell = f(index+1,prices,count,k,dp);
            profit = Math.max(sell,notSell);
        }
        return dp[index][count] = profit;
    }
}
