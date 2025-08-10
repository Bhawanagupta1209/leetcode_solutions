import java.util.*;
public class NinjaTraining {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] points = new int[n][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<3;j++){
                points[i][j] = sc.nextInt();
            }
        }
        System.out.println(ninjaTraining(n,points));
    }
    public static int getMaxPoints(int day,int last,int[][] points){
        if(day==0){
            int max = 0;
            for(int i=0;i<3;i++){
                if(i!=last){
                    max = Math.max(max,points[0][i]);
                }
            }
            return max;
        }
        int max = 0;
        for(int i=0;i<3;i++){
            if(i!=last){
                int val = points[day][i] + getMaxPoints(day-1,i,points);
                max = Math.max(max,val);
            }
        }
        return max;
    }
    public static int ninjaTraining(int n,int[][] points){
        return getMaxPoints(n-1,3,points);
    }
}

