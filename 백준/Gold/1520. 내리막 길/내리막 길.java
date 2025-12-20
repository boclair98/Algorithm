import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n, m;
    static int[][] map = new int[505][505];
    static int[][] dp = new int[505][505];
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int recur(int x, int y){
        if(x == n-1 && y == m-1) return 1;
        if(dp[x][y] != -1) return dp[x][y];
        int res = 0;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
            if(map[nx][ny] < map[x][y]){
                res+=recur(nx, ny);
            }
        }
        return dp[x][y] = res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st =  new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i = 0; i<n; i++){
            st =  new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i<505; i++){
            Arrays.fill(dp[i], -1);
        }
        System.out.println(recur(0, 0));
    }
}

