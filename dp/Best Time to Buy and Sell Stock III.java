class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];
        for(int day=n-1;day>=0;day--){
            for(int canBuy=0;canBuy<=1;canBuy++){
                for(int trans=1;trans<=2;trans++){
                    if(canBuy==1){
                        int buy = -prices[day]+dp[day+1][0][trans];
                        int skip = dp[day+1][1][trans];
                        dp[day][canBuy][trans] = Math.max(buy,skip);
                    } else{
                        int sell = prices[day]+dp[day+1][1][trans-1];
                        int notSell = dp[day+1][0][trans];
                        dp[day][canBuy][trans] = Math.max(sell,notSell);
                    }
                }
            }
        }
        return dp[0][1][2]; 
    }
}
