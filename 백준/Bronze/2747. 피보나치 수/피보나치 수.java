import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(memoization(n));
    }

    private static int memoization(int n) {
        if(n<=2){
            return 1;
        }

        if(dp[n] != -1){
            return dp[n];
        }
        return dp[n] = memoization(n-1) + memoization(n-2);

    }

}
