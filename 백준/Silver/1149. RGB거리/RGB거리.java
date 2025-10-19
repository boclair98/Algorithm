import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static long[][] dp;
    static int[][] cost;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new long[n][3];
        cost = new int[n][3];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<3; j++){
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i<n; i++){
            Arrays.fill(dp[i],-1);
        }
        long result = Long.MAX_VALUE;
        for(int c = 0; c<3; c++){
            result = Math.min(result, memo(n-1, c));
        }
        System.out.println(result);

    }
    static long memo(int idx, int color){
        if(idx == 0){
            return cost[idx][color];
        }
        if(dp[idx][color]!= -1){
            return dp[idx][color];
        }
        long min = Integer.MAX_VALUE;
        for(int i = 0; i<3; i++){
            if(i == color) continue;
            min = Math.min(min,(memo(idx-1,i)));
        }
        dp[idx][color] = min + cost[idx][color];
        return dp[idx][color];
    }
}
