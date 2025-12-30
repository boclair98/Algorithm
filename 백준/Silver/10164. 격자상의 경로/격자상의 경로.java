import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n, m, s;
    static int[][] map;
    static int[][] dp = new int[20][20];
    static int recur(int x,int y,int sx, int sy){
        if(x >= sx || y >=sy) return 0;
        if(x == sx-1 && y == sy -1 ) return 1;
        if(dp[x][y] != -1) return dp[x][y];
        int a = 0;
        a+=recur(x+1,y,sx,sy);
        a+=recur(x,y+1,sx,sy);
        return dp[x][y] = a;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        int idx = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                map[i][j] = idx;
                idx++;
            }
        }
        if(s == 0){
            for(int i = 0; i<20; i++){
                Arrays.fill(dp[i], -1);
            }
            System.out.println(recur(0,0,n,m));
        }else{
            int k = (s -1) / m;
            int ky = (s -1) % m;
            for(int i = 0; i<20; i++){
                Arrays.fill(dp[i], -1);
            }
            int res1 = recur(0,0,k+1,ky+1);
            for(int i = 0; i<20; i++){
                Arrays.fill(dp[i], -1);
            }
            int res2 = recur(k,ky,n,m);
            System.out.println(res1 * res2);
        }

    }
}

