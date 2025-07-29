import java.io.*;
import java.util.*;

public class Main {
    static int n,m,answer;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx ={1,0,-1,0};
    static int[] dy ={0,1,0,-1};
    static int[][]dp ;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dp = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        visited[0][0] = true;
        System.out.println(Backtracking(0,0));

    }

    private static int Backtracking(int x, int y) {

        if(x == n-1 && y == m-1){
            return 1;
        }

        if(dp[x][y] !=-1){
            return dp[x][y];
        }
        dp[x][y] = 0;

        for(int i = 0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(isRange(nx,ny)){
                if(!visited[nx][ny] && map[nx][ny] < map[x][y]){
                    visited[nx][ny] = true;
                    dp[x][y]+=Backtracking(nx,ny);
                    visited[nx][ny] = false;
                }
            }
        }
        return dp[x][y];
    }
    private static boolean isRange(int nx, int ny) {

        return 0<=nx && nx<n && 0<=ny && ny<m;
    }
}
