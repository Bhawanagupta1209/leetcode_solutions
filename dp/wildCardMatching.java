class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n+1][m+1];
        boolean[][] visited = new boolean[n+1][m+1];
        return f(n-1,m-1,s,p,dp,visited);
    }
    public boolean f(int i,int j,String s,String p,boolean[][] dp,boolean[][] visited){
        if(i<0 && j<0) return true;
        if(j<0) return false;
        if(i<0){
            for(int k=0;k<=j;k++){
                if(p.charAt(k) !='*') return false;
            }
            return true;
        }
        if(visited[i][j]) return dp[i][j];
        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?'){
            return dp[i][j]= f(i-1,j-1,s,p,dp,visited);
        } else if(p.charAt(j)=='*'){
            return dp[i][j]= f(i-1,j,s,p,dp,visited) || f(i,j-1,s,p,dp,visited);
        } else {
            dp[i][j] = false;
        }
        visited[i][j] = true;
        return dp[i][j];
        
    }
}
