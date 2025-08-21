class Solution {
    public int perfectSum(int[] arr, int K) {
        int n = arr.length;
        int[][] dp = new int[n][K+1];
        for(int i=0;i<n;i++){
            dp[i][0]=1;
        }
        if(a[0]<K) dp[0][a[0]]=1;
        for(int i=1;i<n;i++){
            for(int s=0;s<K;s++){
                int notPick = dp[i-1][s];
                int pick = 0;
                if(arr[index]<=K){
                    pick = dp[i-1][s-arr[i]];
                }
            }
        }
       return f(n-1,K,arr,dp);
    }
}

