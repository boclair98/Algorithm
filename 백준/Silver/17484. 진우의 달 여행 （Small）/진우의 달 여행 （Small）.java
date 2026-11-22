import javax.imageio.ImageTranscoder;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n,m,answer;
    static int[][] arr;
    static int[][][] dp;
    static int recur(int x,int y ,int turn){
        if(x < 0 || x>=n || y < 0 || y >= m) return 999999999;
        if(x == n-1) return arr[x][y];
        if(dp[x][y][turn] != -1) return dp[x][y][turn];
        int min = Integer.MAX_VALUE;
        if(turn != 0){
            min = Math.min(min,recur(x+1,y-1,0));
        }
        if(turn != 1){
            min = Math.min(min,recur(x+1,y,1));
        }
        if(turn != 2){
            min = Math.min(min,recur(x+1,y+1,2));
        }
        return dp[x][y][turn] = min + arr[x][y];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        dp = new int[n+1][m+1][4];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= m; j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++){
            answer = Math.min(answer,recur(0,i,3));
        }
        System.out.println(answer);
    }
}
