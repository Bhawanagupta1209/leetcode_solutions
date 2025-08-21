class Solution {
    public int minDifference(int[] arr, int n) {
        int totalSum = 0;
        for(int i=0;i<n;i++){
            totalSum += arr[i];
        }
        boolean[][] dp = new boolean[n][totalSum+1];
        for(int i=0;i<n;i++){
            dp[i][0] = true; // Sum 0 is always possible
        }
        for(int s=0;s<=totalSum;s++){
            if(arr[0]==s){
                dp[0][s]=true;
            }
        }
        for(int j=1;j<n;j++){
            for(int k=1;k<=totalSum;k++){
                boolean notTake = dp[j-1][k];
                boolean take = false;
                if(arr[j]<=k){
                    take = dp[j-1][k-arr[j]];
                }
                dp[j][k] = take||notTake;
                
            }
        }
        int diff = (int) 1e9;
        for(int i=0;i<=totalSum/2;i++){
            if(dp[n-1][i]==true){
                int s1=i;
                int s2 = totalSum-i;
                int minDiff = Math.abs(s1-s2);
                diff = Math.min(diff,minDiff);

            }
        }
        return diff;
   
    }
}

