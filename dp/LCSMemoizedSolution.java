class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return f(n-1,m-1,text1,text2,dp);
        
    }
    public int f(int index1,int index2,String text1,String text2,int[][] dp){
        if(index1<0 || index2<0) return 0;
        if(dp[index1][index2]!=-1) return dp[index1][index2];
        if(text1.charAt(index1)==text2.charAt(index2)){
            return dp[index1][index2] = 1 + f(index1-1,index2-1,text1,text2,dp);
        } else{
            return dp[index1][index2] = Math.max(f(index1-1,index2,text1,text2,dp),f(index1,index2-1,text1,text2,dp));
        }
    }
}
