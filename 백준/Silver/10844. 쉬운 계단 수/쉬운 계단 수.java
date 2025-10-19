import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(br.readLine());
        dp = new long[n+1][11];
        for(int i = 0; i<=n; i++){
            Arrays.fill(dp[i],-1);
        }
        for(int i = 1; i<=9; i++){
            dp[1][i] = 1;
        }
        long sum = 0;
        for(int i = 0; i<=9; i++){
            sum+=memoization(n,i);
        }
        System.out.println(sum%1000000000);
    }
    static long memoization(int n, int val){
        if(n == 1){
            if(val == 0) return 0;
            else return 1;
        }
        if(dp[n][val] != -1){
            return dp[n][val];
        }
        if(val == 0){
            dp[n][val] = memoization(n-1,1);
        }
        else if(val == 9){
            dp[n][val] = memoization(n-1,8);
        }else{
            dp[n][val] = memoization(n-1,val+1) + memoization(n-1,val-1);
        }
        dp[n][val] %= 1_000_000_000;
        return dp[n][val];
    }
}
