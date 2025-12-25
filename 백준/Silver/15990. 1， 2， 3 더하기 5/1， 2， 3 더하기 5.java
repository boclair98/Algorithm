import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n;
    static long[][] dp ;
    static long recur(int num, int prev){
        if(num == 0) return 1;
        if(num < 0) return 0;
        if(dp[num][prev] !=-1) return dp[num][prev];
        long ans = 0;
        if(prev != 1) ans = (ans + recur(num-1,1))% 1_000_000_009;
        if(prev != 2) ans = (ans + recur(num-2,2))% 1_000_000_009;
        if(prev != 3) ans = (ans + recur(num-3,3))% 1_000_000_009;
        return dp[num][prev] = ans % 1_000_000_009;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new long[100050][5];
        for(int i = 0; i<100050; i++){
            Arrays.fill(dp[i],-1);
        }
        while(n-->0){
            int goal = Integer.parseInt(br.readLine());
            long a = (recur(goal,0) ) % 1_000_000_009;
//            sb = new StringBuilder();
            sb.append(a).append("\n");
        }
        System.out.println(sb.toString());
    }
}