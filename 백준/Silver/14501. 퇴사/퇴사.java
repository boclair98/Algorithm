import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n;
    static int[] p;
    static int[] t;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(br.readLine());
        p = new int[n+1];
        t = new int[n+1];
        dp = new int[n+2];
        Arrays.fill(dp, -1);
        for(int i = 1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            p[i] = Integer.parseInt(st.nextToken());
            t[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(dfs(1));
    }

    private static int dfs(int day) {
        if(day > n){
            return 0;
        }
        if(dp[day]!=-1){
            return dp[day];
        }
        int result = dfs(day+1);

        if(day + p[day] -1 <=n){
            result = Math.max(result, t[day]+dfs(day+p[day]));
        }
        return dp[day] = result;


    }
}
