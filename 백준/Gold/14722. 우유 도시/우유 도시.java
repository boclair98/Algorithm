import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static StringBuilder sb;
    static StringTokenizer st;
    static int n;
    static int[][] map;
    static int[] dx = {1,0};
    static int[] dy ={0,1};
    static boolean[][] visited;
    static int[][][] dp = new int[1010][1010][5];
    static int recur(int x, int y, int prev){
        if(x == n-1 && y == n-1) return 0;
        if(dp[x][y][prev] != -1) return dp[x][y][prev];
        int ans = -Integer.MAX_VALUE;
        for(int i = 0; i < 2; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            int next = (prev+1) % 3;
            if(nx < 0 || nx >=n || ny < 0 || ny >= n) continue;
            if(map[nx][ny] == next){
                ans = Math.max(ans,recur(nx,ny,next)+1);
            }else{
                ans = Math.max(ans,recur(nx,ny,prev));
            }
        }
        return dp[x][y][prev] = ans;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < 1010; i++){
            for(int j = 0; j < 1010; j++){
                for(int k = 0; k < 5; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        int start = -1;
        int count = 0;
        if(map[0][0] == 0){
            start = 0;
            count = 1;
        }else{
            start = 2;
        }
        System.out.println(recur(0,0,start)+count);
    }
}