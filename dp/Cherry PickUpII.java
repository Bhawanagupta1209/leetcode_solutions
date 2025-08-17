class Solution {
    public int cherryPickup(int[][] grid) {
        int row = grid.length;
        int cols = grid[0].length;
        int[][][] dp = new int[row][cols][cols];
        for(int i=0;i<row;i++){
            for(int j1=0;j1<cols;j1++){
                for(int j2=0;j2<cols;j2++){
                    dp[i][j1][j2] = -1;
                }
            }
        }
        return f(0,0,cols-1,grid,dp);      
    }
    public static int f(int i,int j1,int j2,int[][] grid,int[][][] dp){
        int row = grid.length;
        int cols = grid[0].length;
        if(j1<0 || j1>=cols || j2<0 || j2>=cols) return (int) -1e8;
        if(i==row-1){
            if(j1==j2) return grid[i][j2];
            else{
                return grid[i][j1]+grid[i][j2];
            }
        }
        if(dp[i][j1][j2]!=-1) return dp[i][j1][j2];
        int maxi = 0;
        for(int d1=-1;d1<=+1;d1++){
            for(int d2=-1;d2<=+1;d2++){
                if(j1==j2){
                    maxi = Math.max(maxi,grid[i][j1]+f(i+1,d1+j1,d2+j2,grid,dp));
                }else{
                    maxi = Math.max(maxi,grid[i][j1]+grid[i][j2]+f(i+1,d1+j1,d2+j2,grid,dp));
                } 
            }
        }
        return dp[i][j1][j2] = maxi;
    }
}
