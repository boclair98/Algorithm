import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;

    static int n;
    static long[] dp = new long[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int j = 4; j<=1000000; j++){
            dp[j] = (dp[j-3] + dp[j-2] + dp[j-1]) % 1000000009;
        }
        for(int i = 0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            System.out.println(dp[num]);
        }

    }


}
