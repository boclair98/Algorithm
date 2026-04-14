import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n,m;
    static int[][] arr = new int[5000][2];
    static int[][] dp;
    static int recur(int idx, int total){
        if(total > m) return -999999999;
        if(idx > n) return -999999999;
        if(idx == n) return 0;
        if(dp[idx][total] != -1) return dp[idx][total];
        int ans = recur(idx+1,total);
        ans = Math.max(ans,recur(idx+1,total+arr[idx][0])+arr[idx][1]);
        return dp[idx][total] = ans;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        dp = new int[n+1][m+1];
        for(int i = 0; i <= n; i++){
            Arrays.fill(dp[i],-1);
        }
        System.out.println(recur(0,0));

    }
}

