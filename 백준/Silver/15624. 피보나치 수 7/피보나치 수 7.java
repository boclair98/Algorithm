import java.io.*;
import java.util.Arrays;

public class Main {
    static int[] dp;
    static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        
        System.out.println(recur(n));
    }

    static int recur(int idx) {
        if (idx <= 1) return idx;
        if (dp[idx] != -1) return dp[idx];
        
        // Memoization 적용 및 나머지 연산
        return dp[idx] = (recur(idx - 1) + recur(idx - 2)) % MOD;
    }
}
