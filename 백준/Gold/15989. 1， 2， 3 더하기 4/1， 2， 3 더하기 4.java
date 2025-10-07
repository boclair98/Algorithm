import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;

    static int n;
    static long[][] dp = new long[1000001][4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        dp[1][1] = 1;
        dp[1][2] = 0;
        dp[1][3] = 0;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[2][3] = 0;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;
        for(int j = 4; j<=1000000; j++){
            dp[j][1] = 1;
            dp[j][2] = dp[j-2][1] + dp[j-2][2];
            dp[j][3] = dp[j-3][1] + dp[j-3][2] + dp[j-3][3];

        }
        for(int i = 0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            System.out.println(dp[num][1]+dp[num][2]+dp[num][3]);
        }

    }


}
