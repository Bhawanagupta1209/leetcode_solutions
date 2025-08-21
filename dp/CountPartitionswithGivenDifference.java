class Solution {
 public int countPartitions(int n, int diff, int[] arr) {
    int totalSum = 0;
    for(int i=0;i<n;i++){
        totalSum+=arr[i];
    }
    if((totalSum-diff)<0 || (totalSum-diff)%2!=0) return 0;
    int K = (totalSum-diff)/2;
    int mod = (int) 1e9+7;
    int[][] dp = new int[n][K+1];
    for(int i=0;i<n;i++){
        dp[i][0] = 1; // 0 sum is always achievable
    }
    if(arr[0]<=K) dp[0][arr[0]]=1;
    for(int i=1;i<n;i++){
        for(int s=0;s<=K;s++){
            int notPick = dp[i-1][s];
            int pick = 0;
            if(arr[i]<=s){
                pick = dp[i-1][s-arr[i]];
            }
            dp[i][s] = (pick+notPick)%mod;
        }
        
    }
    return dp[n-1][K];
 }
}

