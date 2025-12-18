import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n,m;
    static int[][] map;
    static int[][] dp;
    static int[] dx ={1,1,0};
    static int[] dy ={0,1,1};
    static int max_val = 0;
    static int recur(int x, int y){
        if(x<0 || x>=n || y<0 || y>=m) return 0;
        if(x == n-1 && y == m-1){
            return map[x][y];
        }
        if(dp[x][y]!=-1){
            return dp[x][y];
        }
        int a = 0;
        for(int i = 0; i<3; i++){
            a = Math.max(a,recur(x+dx[i],y+dy[i]));
        }
        return dp[x][y] = a + map[x][y];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        dp = new int[n][m];
        for(int i = 0; i< n; i++){
            for(int j = 0; j<m; j++){
                dp[i][j] = -1;
            }
        }
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(recur(0,0));
    }
}