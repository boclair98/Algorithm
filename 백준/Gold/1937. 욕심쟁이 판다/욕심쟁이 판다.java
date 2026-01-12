import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n;
    static int[][] map;
    static int[][] dp;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int recur(int sx, int sy){
        if(dp[sx][sy] != -1) return dp[sx][sy];
        dp[sx][sy] = 1;
        int ans = 1;
        for(int i = 0; i < 4; i++){
            int nx = sx + dx[i];
            int ny = sy + dy[i];
            if(nx < 0 || nx>=n || ny < 0 || ny >= n) continue;
            if(map[sx][sy] < map[nx][ny]){
                ans = Math.max(ans, recur(nx,ny)+1);
            }
        }
        return dp[sx][sy] = ans;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        int num = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                num = Math.max(num,recur(i,j));
            }
        }
        System.out.println(num);
    }
}