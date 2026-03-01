import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static StringBuilder sb;
    static StringTokenizer st;
    static int n;
    static int[][] arr;
    static int[] dp;
    static int recur(int idx){
        if(idx >= n) return 0;
        if(dp[idx] != -1) return dp[idx];
        int ans = recur(idx+1);
        ans = Math.max(ans,recur(idx+2)+arr[idx][2]);
        return dp[idx] = ans;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][3];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }
        dp = new int[n];
        Arrays.fill(dp,-1);
        System.out.println(recur(0));
    }
}