import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n;
    static long[] dp ;
    static long recur(int num){
        if(num == 0) return 1;
        if(num < 0) return 0;
        if(dp[num]!=-1) return dp[num];
        long ans = 0;
        ans+=recur(num-1);
        ans+=recur(num-2);
        ans+=recur(num-3);
        return dp[num] = ans;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new long[100050];
        Arrays.fill(dp,-1);
        while(n-->0){
            int goal = Integer.parseInt(br.readLine());
            long a = (recur(goal) );
//            sb = new StringBuilder();
            sb.append(a).append("\n");
        }
        System.out.println(sb.toString());
    }
}