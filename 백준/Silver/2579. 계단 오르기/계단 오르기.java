import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[10001];
        int[] state = new int[10001];
        for(int i = 1; i<=n; i++){
            state[i] = Integer.parseInt(br.readLine());
        }
        dp[1] = state[1];
        dp[2] = state[2] + dp[1];
        for(int i = 3; i<=n; i++){
            dp[i] = Math.max(state[i]+dp[i-2],state[i]+state[i-1]+dp[i-3]);
        }
        System.out.println(dp[n]);
    }
}