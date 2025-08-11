mport java.util.*;
public class NinjaTrainingTabulation {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] points = new int[n][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<3;j++){
                points[i][j] = sc.nextInt();
            }
        }
        int result = ninjaTraining(n, points);
        System.out.println("Maximum merit points: " + result);
    }
    public static int ninjaTraining(int n,int[][] points){
        int[][] dp = new int[n][4];
        // Base Case Day 0
        for(int last=0;last<4;last++){
            int maxPoints = 0;
            for(int task = 0;task<3;task++){
                if(task!=last){
                    maxPoints = Math.max(maxPoints,points[0][task]);
                }
            }
            dp[0][last] = maxPoints;
        }
        for(int day = 1;day<n;day++){
            for(int last =0;last<4;last++){
                dp[day][last] = 0;
                for(int task = 0;task<3;task++){
                    if(task!=last){
                        int point = points[day][task] + dp[day-1][task];
                        dp[day][last] = Math.max(dp[day][last],point);
                    }
                }
            }
        }
        return dp[n - 1][3];
    }
}

