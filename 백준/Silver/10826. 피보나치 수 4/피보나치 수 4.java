import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static BigInteger[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new BigInteger[n+1];
//        Arrays.fill(dp,-1);
        System.out.println(memoization(n));
    }

    private static BigInteger memoization(int n) {
        if(n == 0){
            return BigInteger.ZERO;
        }
        if(n<=2){
            return BigInteger.ONE;
        }

        if(dp[n] != null){
            return dp[n];
        }
        return dp[n] = memoization(n-1).add(memoization(n-2));

    }

}
