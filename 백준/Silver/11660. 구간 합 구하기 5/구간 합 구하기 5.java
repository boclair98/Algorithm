import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n,m;
    static int[][] arr = new int[1030][1030];
    static int[][] dp = new int[1030][1030];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + arr[i][j];
            }
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int area = 0;
//            System.out.println(dp[x1][y1] + " "+ dp[x2][y2]);
            System.out.println(dp[x2][y2] - dp[x2][y1-1] - dp[x1-1][y2]+dp[x1-1][y1-1]);

        }
    }
}

