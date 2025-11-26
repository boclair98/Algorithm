import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int n;
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        dp = new int[n+1];
        Arrays.fill(dp,100000000);
        dp[0] = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=i; j++){
                dp[i] = Math.min(dp[i],arr[j] + dp[i-j]);
            }
        }
        System.out.println(dp[n]);

    }
}
