class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][k+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                for(int x=0;x<=k;x++){
                    dp[i][j][x]=-1;
                }
            }
        }
        return f(0,prices,k,1,dp);
    }
    public int f(int index,int[] prices,int count,int buy,int[][][] dp){
        if(index==prices.length) return 0;
        if(count == 0) return 0;
        if(dp[index][buy][count]!=-1) return dp[index][buy][count];
        int profit;
        if(buy==1){
            int canbuy = -prices[index]+f(index+1,prices,count,0,dp);
            int notBuy = f(index+1,prices,count,1,dp);
            profit = Math.max(canbuy,notBuy);
        } else{
            int sell = prices[index]+f(index+1,prices,count-1,1,dp);
            int notSell = f(index+1,prices,count,0,dp);
            profit = Math.max(sell,notSell);
        }
        return dp[index][buy][count] = profit;

    }
}
