import java.util.*;
class Main {
    public static int frogJump(int ind,int[] heights,int k,int[] dp) {
        int n = heights.length;
        if(dp[ind]!=-1) return dp[ind];
        if(ind == 0) return 0;
        int minSteps = Integer.MAX_VALUE;
        for(int j=1;j<=k;j++){
            if(ind-j >= 0){
                int jump = frogJump(ind-j,heights,k,dp)+Math.abs(heights[ind]-heights[ind-j]);
                minSteps = Math.min(minSteps,jump);
            }
            
        }
        dp[ind] = minSteps;
        return dp[ind];

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] heights = new int[n];
        for(int i=0;i<n;i++){
            heights[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        System.out.print(frogJump(n-1,heights,k,dp)); // Output: 30
    }
