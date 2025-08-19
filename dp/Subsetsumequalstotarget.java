import java.util.*;
class Main {
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int[] arr = new int[n];
      for(int i=0;i<n;i++){
          arr[i] = sc.nextInt();
      }
      int target = sc.nextInt();
      System.out.println(isSubsetSum(arr,target));
  }
  public static boolean isSubsetSum(int[] arr,int target){
      int n = arr.length;
      boolean[][] dp = new boolean[n][target+1];
      for(int i=0;i<n;i++){
          dp[i][0]=true;
      }
      if(arr[0]<=target){
          dp[0][arr[0]]=true;
      }
      for(int ind=1;ind<n;ind++){
          for(int t=1;t<=target;t++){
              boolean notTake = dp[ind-1][t];
              boolean take = false;
              if(t>=arr[ind]){
                  take = dp[ind-1][t-arr[ind]];
              }
              dp[ind][t] = take||notTake;
          }
      }
      return dp[n-1][target];
  }
}
