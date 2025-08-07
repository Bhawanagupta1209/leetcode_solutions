import java.util.*;
class Main {
    public static int frogJump(int[] heights,int k) {
        int n = heights.length;
        int[] dp = new int[n];
        dp[0] = 0;
        for(int i=1;i<n;i++){
            int minSteps = Integer.MAX_VALUE;
            for(int j=1;j<=k;j++){
                if(i-j >= 0){
                    int jump = dp[i-j]+Math.abs(heights[i]-heights[i-j]);
                    minSteps = Math.min(minSteps,jump);
                }
            }
            dp[i] = minSteps;
        }
        return dp[n-1];
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
        System.out.print(frogJump(heights,k)); // Output: 30
    }
    
}
