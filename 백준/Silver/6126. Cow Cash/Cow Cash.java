import java.awt.color.ColorSpace;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n,m;
    static int[] arr = new int[1000];
    static long [][] dp;
    static long recur(int idx, int total){
        if(total == m) return 1;
        if(total > m) return 0;
        if(idx == n) return 0;
        if(dp[idx][total] != -1) return dp[idx][total];
        long ans = recur(idx+1,total);
        ans+=recur(idx,total+arr[idx]);
        return dp[idx][total] = ans;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp = new long[n+1][m+1];
        for(int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(recur(0,0));
    }

}
