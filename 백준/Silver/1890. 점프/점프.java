import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n;
    static int[][] map;
    static long[][] dp = new long[105][105];
    static long recur(int x, int y){
        if(x >= n || y >= n) return 0;
        if(x == n-1 && y == n-1) return 1;
        if(map[x][y] == 0) return 0;
        if(dp[x][y] != -1) return dp[x][y];
        long a = 0;
        a += recur(x + map[x][y], y);
        a += recur(x, y + map[x][y]);
        return dp[x][y] = a;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i<105; i++){
            Arrays.fill(dp[i], -1);
        }
        System.out.println(recur(0,0));
    }
}

