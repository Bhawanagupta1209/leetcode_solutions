class Solution {
    public int unboundedKnapsack(int[] wt, int[] val, int n, int W) {
        int[][] dp = new int[n][W+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return f(n-1,W,wt,val,dp);
    }
    public int f(int index,int W,int[] wt,int[] val,int[][] dp){
        if(index==0){
            if(wt[0]<=W){
                return (W/wt[0])*val[0];
            }else{
                return 0;
            }            
        }
        if(dp[index][W]!=-1) return dp[index][W];
        int notTake = 0+f(index-1,W,wt,val,dp);
        int Take = Integer.MIN_VALUE;
        if(wt[index]<=W){
            Take = val[index]+f(index,W-wt[index],wt,val,dp);
        }
        dp[index][W] = Math.max(Take,notTake);
        return dp[index][W];
    }
}
